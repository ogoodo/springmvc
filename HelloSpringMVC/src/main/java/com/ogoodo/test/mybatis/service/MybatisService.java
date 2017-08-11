package com.ogoodo.test.mybatis.service;

import com.ogoodo.test.mybatis.pojo.URole;
import com.ogoodo.test.mysql.User;

public interface MybatisService {

    URole selectByPrimaryKey(Long userId);  

    int insertSelective(URole record);
}
