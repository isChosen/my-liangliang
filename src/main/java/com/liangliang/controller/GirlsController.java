package com.liangliang.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.liangliang.entity.GirlsBean;
import com.liangliang.service.GirlsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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
    // all girls
    // 单个域名时不需要花括号
    // @CrossOrigin(origins = {"http://localhost:63343", "http://localhost:8020"})
    @RequestMapping(value="/queryAllGirls", method = RequestMethod.GET)
    public List<GirlsBean> getNames(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        /* 第一个参数是第几页；第二个参数是每页显示条数 */
        PageHelper.startPage(pn, 3);
        return girlsService.getAllGirls();

    }
    // part of girls due to the parameter
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
