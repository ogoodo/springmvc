package com.ogoodo.test.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ogoodo.test.mybatis.mapper.URoleMapper;
import com.ogoodo.test.mybatis.pojo.URole;

@Service  
public class MybatisServiceImpl implements MybatisService{

    @Autowired  
    private URoleMapper userDao;

	// @Override
	public URole selectByPrimaryKey(Long userId) {
		return userDao.selectByPrimaryKey(userId);
	}

	// @Override
	public int insertSelective(URole record) {
		return userDao.insertSelective(record);
	}  

//	@Override
//    public URole selectByPrimaryKey(long userId) {  
//        return userDao.selectByPrimaryKey(userId);  
//    }
  
}  
