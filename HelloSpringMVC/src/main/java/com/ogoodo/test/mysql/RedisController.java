package com.ogoodo.test.mysql;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ogoodo.test.mysql.service.UserService;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


@Controller
public class RedisController {
	
	@Autowired
	private JedisPool jedisPool;
	
	
	private static Logger logger = LoggerFactory.getLogger(RedisController.class);

	/**
	 * http://localhost:8080/HelloSpringMVC/test/redis?key=key1&value=value1
	 * redis图像客户端 http://www.jianshu.com/p/214baa511f2e
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/test/redis")
	public Map<String,Object> saveRegistration(String key, String value, Locale locale){
		
        Jedis jedis = jedisPool.getResource();
        //存值
        jedis.set("user.name", "aaa");
        jedis.set("user.pass", "123");
         
        //取值
        String name = jedis.get("user.name");
        String pass = jedis.get("user.pass");
         
        jedis.del("user.name");
        Boolean result = jedis.exists("user.name");
         
        result = jedis.exists("user.pass");
        jedis.close();

        Jedis jedis2 = jedisPool.getResource();
        jedis2.set("my.test." + key , value);
        jedis2.close();
        

        Map<String,Object> map=new HashMap<String,Object>();
        Map<String,Object> data=new HashMap<String,Object>();
        data.put(key, value);
        map.put("code", "10001");
        map.put("msg", "请求参数校验成功！！！");
        map.put("data", data);
        return map;
	}
}
