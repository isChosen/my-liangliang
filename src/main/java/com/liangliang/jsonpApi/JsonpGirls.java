package com.liangliang.jsonpApi;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.liangliang.entity.GirlsBean;
import com.liangliang.service.GirlsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/jsonpGirls")
public class JsonpGirls {

    @Resource
    private GirlsService girlsService;
    // all girls
    @RequestMapping(value="/queryAllGirls", method = RequestMethod.GET)
    public List<GirlsBean> getNames() {
         return girlsService.getAllGirls();
    }
    @RequestMapping(value="/queryGirlsByName", produces = "application/json;charset=UTF-8")
    public List<GirlsBean> getNames(@RequestBody String request) {
        JSONObject json = JSON.parseObject(request);
        String girlsName = json.getString("name");
        return girlsService.getGirlsName(girlsName);
    }
}
