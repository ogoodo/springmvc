package com.ogoodo.valid;

import java.util.List;
import java.util.Locale;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ValidController {

	@Autowired
    private ResourceBundleMessageSource messageSource;
	@Autowired
	private MessageSourceAccessor messageAccessor;
//	private ReloadableResourceBundleMessageSource messageSource;
	/**
	 * 经验: 表单验证要用ConstraintValidator, 搞了两天用formatters方向错了,报错格式老是有异常,浪费整整周末两天时间
	 * 如果同时存在ConstraintValidator和formatters, 那么两个都会执行,先执行formatters在执行ConstraintValidator
	 * ,如果两个都不通过, 那就只会有formatters的报错信息, formatters的报错信息带了异常, 返回给用户不友好, 处理方式
	 * 1. 从一长串异常错误里, 用特定的分割符, 提取有用的信息， 这样可以不写ConstraintValidator
	 * 2. 让formatters不报错, 在ConstraintValidator做检测不通过， 这样就要多写个ConstraintValidator
	 */
	/**
	 * 验证:  
	 * 		 http://localhost:8080/HelloSpringMVC/valid?name=chen&age=12&birthday=2012-12-12%2010:10:10&regDate=2013-11-11&phone=010-12345678&siteLanguage=zh_US
	 * 		 http://localhost:8080/HelloSpringMVC/valid?name=chenchenchen&age=1&siteLanguage=en_US
	 * 		 http://localhost:8080/HelloSpringMVC/valid?name=chenchenchen&age=1&siteLanguage=zh_CN
	 * 		 http://localhost:8080/HelloSpringMVC/valid?name=chenchenchen&age=1&birthday=2012-12-12%2010:10:10&siteLanguage=zh_US
	 */
	@ResponseBody
	@RequestMapping(value="/valid")
	public Map<String,Object> saveRegistration(@Valid User user, BindingResult result, Locale locale){
		
		Locale locale2 = LocaleContextHolder.getLocale();
		String testLocale = messageSource.getMessage("user.id.null", null, locale);
        System.out.println("当前国际化:" + testLocale);
        System.out.println("当前国际化:" + locale2 + ", " + locale);

		if(result.hasErrors()) {
	        Map<String,Object> map=new HashMap<String,Object>(); 
            Map<String,Object> data = new HashMap<String, Object>();

            List<FieldError> list = result.getFieldErrors();  
            for (FieldError err : list) {
                data.put(err.getField(), err.getDefaultMessage());
            }  
            System.out.println("error{{");
            // List<ObjectError> ls = result.getAllErrors();  
            for (FieldError err : result.getFieldErrors()) {
                System.out.println("error.name: " + err.getObjectName() + "." + err.getField());
                System.out.println("error.code: " + Arrays.toString(err.getCodes()));
                System.out.println("error.msg: " + err.getDefaultMessage());
                // 这里要这样调用,参考: https://stackoverflow.com/questions/2751603/how-to-get-error-text-in-controller-from-bindingresult
                String tt = err.getArguments()[0].toString();
                String message = messageSource.getMessage(err, locale);
                // String msg = messageSource.getMessage(err.getCode(), err.getArguments(), err.getDefaultMessage(), locale);
                System.out.println("error.i18n: " + message);
                System.out.println("");
                // System.out.println(msg);
            }
            System.out.println("error}}");
	        map.put("code", "10004");
	        map.put("msg", "请求参数校验失败！！！");
	        map.put("data", data);
	        map.put("msgs1","user.id.null");
	        map.put("msgs2","{user.id.null}");
	        // map.put("msgs3", testLocale);
	        return map;
		}

        Map<String,Object> map=new HashMap<String,Object>();
        map.put("code", "10001");
        map.put("msg", "请求参数校验成功！！！");
        return map;
	}
}
