package com.ogoodo.test.mysql.service;

import com.ogoodo.test.mysql.User;

public interface UserService {
	
    User selectUserById(Integer userId);  
}
