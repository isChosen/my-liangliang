package com.liangliang.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.liangliang.dao.GirlsDao;
import com.liangliang.entity.GirlsBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * Author: Administrator
 * Date: 2018/4/5
 * Description
 */

@Service
public class GirlsService {
    @Resource
    private GirlsDao girlsDao;

    // all girls
    public Map<String, Object> getAllGirls(int pageNum, int pageSize) {
        Map<String, Object> map = new HashMap<String, Object>();
        /* 第一个参数是第几页；第二个参数是每页显示条数 */
        PageHelper.startPage(pageNum, pageSize);
        List<GirlsBean> allGirls = girlsDao.getAllGirls();

        Page girlsPageList = (Page) allGirls;
        int totalPages = girlsPageList.getPages();
        long totalCount = girlsPageList.getTotal();

        map.put("allGirls", allGirls);
        map.put("totalPages", totalPages);
        map.put("totalCount", totalCount);

        return map;
    }
    // part of girls
    public List<GirlsBean> getGirlsName(String name) {
        return girlsDao.getGirlsName(name);
    }
}
