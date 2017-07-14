package com.ogoodo.springmvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;  
import java.util.Map;

@Controller
public class HelloWorldController {

	private static Logger logger = LoggerFactory.getLogger(HelloWorldController.class);
	
    @RequestMapping("/hello")
    @ResponseBody
    public String hello(Model model) {
         
        model.addAttribute("greeting", "Hello Spring MVC add by cxb2");
        
        logger.error("error");
        logger.warn("warn");
        logger.info("info");
        logger.debug("debug");
        logger.trace("trace");

        return"helloworld";
         
    }

    // http://localhost:8080/HelloSpringMVC/ajaxTest?name=%E5%8F%91%E7%9A%84fd1&password=2
    // @RequestMapping(value="/ajaxTest", produces="application/json")
    @RequestMapping(value="/ajaxTest")  
    @ResponseBody
    public Map<String,Object> ajaxTest(String name,String password) {  
        System.out.println("name:"+name+",password:"+password);  
          
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("msg", "我接到ajax请求了！！！");
        map.put("name", name);
          
        return map;  
    }  
 
}