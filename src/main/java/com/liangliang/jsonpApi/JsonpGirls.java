package com.liangliang.jsonpApi;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.liangliang.entity.GirlsBean;
import com.liangliang.service.GirlsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/jsonpGirls")
public class JsonpGirls {

    @Resource
    private GirlsService girlsService;
    // all girls
    /*
    @RequestMapping(value="/queryAllGirls", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public JSONObject getAllGirls(@RequestBody String request) {
        JSONObject retJson = new JSONObject();
        JSONObject json = JSON.parseObject(request);
        int pageNum = json.getString("pageNum") == null? 1: json.getIntValue("pageNum");
        int pageSize = json.getString("pageSize") == null? 10: json.getIntValue("pageSize");

        List<GirlsBean> allGirls = girlsService.getAllGirls(pageNum, pageSize);
        retJson.put("girlsData", allGirls);
        return retJson;
    }
    */
    @RequestMapping(value="/queryGirlsByName", produces = "application/json;charset=UTF-8")
    public List<GirlsBean> getNames(@RequestBody String request) {
        JSONObject json = JSON.parseObject(request);
        String girlsName = json.getString("name");
        return girlsService.getGirlsName(girlsName);
    }
}
