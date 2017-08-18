package com.ogoodo.test.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PageUtil<T> {

	static public <T> Map<String,Object> Change(List<T> list) {
        Map<String, Object> map=new HashMap<String, Object>();
		PageBean<T> dataWithPage = new PageBean<T>(list);
		map.put("data", dataWithPage);
        map.put("code", "10001");
        map.put("msg", "请求参数校验成功！");
        // logger.debug("查找结果" + list);
        return map;
	}

//	static public Map<String,Object> Change2(List list) {
//        Map<String,Object> map=new HashMap<String,Object>();
//		PageBean dataWithPage = new PageBean(list);
//		map.put("data", dataWithPage);
//        map.put("code", "10001");
//        map.put("msg", "请求参数校验成功！！！");
//        return map;
//	}
}
