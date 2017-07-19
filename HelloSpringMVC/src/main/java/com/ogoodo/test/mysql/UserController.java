package com.ogoodo.test.mysql;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ogoodo.springmvc.HelloWorldController;
import com.ogoodo.test.mysql.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@Controller
public class UserController {
	
	@Autowired  
    private UserService userService; 
	
	
	private static Logger logger = LoggerFactory.getLogger(UserController.class);

	/**
	 * http://localhost:8080/HelloSpringMVC/test/mysql?userid=13
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/test/mysql")
	public Map<String,Object> saveRegistration(int userid, Locale locale){
        Map<String,Object> map=new HashMap<String,Object>();
		try {
			User user = userService.selectUserById(userid);  
			map.put("data", user);
	        logger.debug("查找结果" + user);
		} catch(Exception ex) {
			System.out.println("捕获到错误: " + ex.getMessage());
		}
        map.put("code", "10001");
        map.put("msg", "请求参数校验成功！！！");
        return map;
	}
}
