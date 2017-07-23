package com.ogoodo.shiro;

import java.util.LinkedHashMap;

public class FilterChainDefinitionMapBuilder {

		// 这里可以从数据库里读出来
		public LinkedHashMap<String, String> builderFilterChainDefinitionMap() {
			LinkedHashMap<String, String> map = new LinkedHashMap<>();

			map.put("/test/**", "anon");
			map.put("/dologin", "anon");
			map.put("/login.jsp", "anon");
			map.put("/logout", "logout");
			map.put("/user.jsp", "anon");
			map.put("/user.jsp", "roles[user]");
			map.put("/admin.jsp", "roles[admin]");
			map.put("/**", "anon");
			map.put("/**", "authc");
			return map;
		}
}
