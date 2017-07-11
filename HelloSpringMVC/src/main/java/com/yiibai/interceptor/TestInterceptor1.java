package com.yiibai.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class TestInterceptor1 implements HandlerInterceptor {

	// afterCompletion：在整个视图渲染完毕之后执行方法里面的内容，主要用于释放一些资源
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("TestInterceptor1.afterCompletion()");
	}

	// postHandle：在Controller执行之后，视图渲染之前执行方法里面的内容，也就是说postHandle方法可以对Model进行操作
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("TestInterceptor1.postHandle()");
	}

	// preHandle：在Controller执行之前，执行方法里面的内容，注意该方法是有返回值的，当方法返回false时整个请求就结束了
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TestInterceptor1.preHandle()");
        return true;
	}

}
