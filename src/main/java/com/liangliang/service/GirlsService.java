package com.liangliang.service;

import com.liangliang.dao.GirlsDao;
import com.liangliang.entity.GirlsBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
    public List<GirlsBean> getAllGirls() {
        return girlsDao.getAllGirls();
    }
    // part of girls
    public List<GirlsBean> getGirlsName(String name) {
        return girlsDao.getGirlsName(name);
    }
}
