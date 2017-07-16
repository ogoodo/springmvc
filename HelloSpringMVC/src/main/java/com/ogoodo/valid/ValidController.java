package com.ogoodo.valid;

import java.util.List;
import java.util.Locale;
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
            List<ObjectError> ls = result.getAllErrors();  
            for (ObjectError err : ls) {
                System.out.println("error:"+ err.getCode() +"," + err.getObjectName() + err.getDefaultMessage());
                // 这里要这样调用,参考: https://stackoverflow.com/questions/2751603/how-to-get-error-text-in-controller-from-bindingresult
                String message = messageSource.getMessage(err, locale);
                // String msg = messageSource.getMessage(err.getCode(), err.getArguments(), err.getDefaultMessage(), locale);
                System.out.println("    " + message + "\n");
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
