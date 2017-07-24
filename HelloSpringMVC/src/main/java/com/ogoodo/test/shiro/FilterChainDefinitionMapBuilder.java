package com.ogoodo.test.shiro;

import java.util.LinkedHashMap;

public class FilterChainDefinitionMapBuilder {

		// 这里可以从数据库里读出来
		public LinkedHashMap<String, String> builderFilterChainDefinitionMap() {
			LinkedHashMap<String, String> map = new LinkedHashMap<>();

//			map.put("/test.html", "anon");
//			map.put("/test/mysql/**", "anon");
//			map.put("/test/redis/**", "anon");

			map.put("/test/shiro/list.jsp", "anon");
			map.put("/test/shiro/login.do", "anon");
			map.put("/test/shiro/login.jsp", "anon");
			// map.put("/test/shiro/logout.do", "logout");
			map.put("/test/shiro/user.jsp", "anyRoles[\"user,admin\"]");
//			map.put("/test/shiro/user.jsp", "roles[admin]");
//			map.put("/test/shiro/user.jsp", "roles[user]");
			map.put("/test/shiro/admin.jsp", "roles[admin]");
			map.put("/test/shiro/**", "anon");
			
			
//			map.put("/HelloSpringMVC/test/shiro/list.jsp", "anon");
//			map.put("/HelloSpringMVC/test/shiro/login", "anon");
//			map.put("/HelloSpringMVC/test/shiro/login.jsp", "anon");
//			map.put("/HelloSpringMVC/test/shiro/logout", "logout");
//			map.put("/HelloSpringMVC/test/shiro/user.jsp", "roles[user]");
//			map.put("/HelloSpringMVC/test/shiro/admin.jsp", "roles[admin]");
//			map.put("/HelloSpringMVC/test/shiro/**", "authc");
			
//			map.put("/HelloSpringMVC/**", "anon");
//			map.put("/HelloSpringMVC/**", "authc");
			return map;
		}
}
