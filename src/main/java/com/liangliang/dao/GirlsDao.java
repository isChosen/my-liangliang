package com.liangliang.dao;

import com.liangliang.entity.GirlsBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GirlsDao {

    List<GirlsBean> getGirlsName(String name);

    List<GirlsBean> getAllGirls();

}
