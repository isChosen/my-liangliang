package com.liangliang.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.liangliang.entity.GirlsBean;
import com.liangliang.service.GirlsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * Author: Administrator
 * Date: 2018/4/5
 * Description
 */

@RestController
@RequestMapping("/girls")
public class GirlsController {

    @Resource
    private GirlsService girlsService;
    // all girls, 有分页
    // 单个域名时不需要花括号
    @CrossOrigin(origins = {"http://localhost:63343", "http://localhost:8020", "http://localhost:4300"})
    @RequestMapping(value="/queryAllGirls", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public Map<String, Object> getAllGirls(@RequestBody String request) {
        JSONObject json = JSON.parseObject(request);
        int pageNum = json.getString("pageNum") == null? 1: json.getIntValue("pageNum");
        int pageSize = json.getString("pageSize") == null? 10: json.getIntValue("pageSize");

        return girlsService.getAllGirls(pageNum, pageSize);
    }
    // girls with the same name, 没有做分页
    // 注意：使用了 produces 属性，js 发送请求时必须设置 Content-Type = 'UTF-8'
    // 单个域名时不需要花括号
    @CrossOrigin(origins = {"http://localhost:63343", "http://localhost:8020", "http://localhost:8088"})
    @RequestMapping(value="/queryGirlsByName", method = {RequestMethod.POST, RequestMethod.GET},
            produces = "application/json; charset=UTF-8")
    public List<GirlsBean> getNames(@RequestBody String request) {
        JSONObject json = JSON.parseObject(request);
        String girlsName = json.getString("name");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return girlsService.getGirlsName(girlsName);
    }
}
