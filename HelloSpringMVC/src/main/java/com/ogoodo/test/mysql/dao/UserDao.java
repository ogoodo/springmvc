package com.ogoodo.test.mysql.dao;

import com.ogoodo.test.mysql.User;

public interface UserDao {  
    /** 
     *  
     * @author linbingwen 
     * @since 2015年9月28日 
     * @param userId 
     * @return 
     */  
    public User selectUserById(Integer userId);  
  
} 
