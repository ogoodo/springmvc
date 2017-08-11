package com.ogoodo.test.mybatis;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ogoodo.test.mybatis.pojo.URole;
import com.ogoodo.test.mybatis.service.MybatisService;
import com.ogoodo.test.mybatis.service.MybatisServiceImpl;

@Controller
public class MybatisController {


	@Autowired  
    private MybatisServiceImpl mybatisService; 
	
	
	private static Logger logger = LoggerFactory.getLogger(MybatisController.class);

	/**
	 * http://localhost:8080/HelloSpringMVC/test/mybatis?userid=13
	 */
	@ResponseBody
	@RequestMapping(value="/test/mybatis")
	public Map<String,Object> saveRegistration(long userid, Locale locale){
        Map<String,Object> map=new HashMap<String,Object>();
		try {
			URole user = mybatisService.selectByPrimaryKey(userid);  
			URole role = new URole();
			role.setName("cxbte");
			role.setType("12323");
			userid = mybatisService.insertSelective(role);
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
