package com.ogoodo.valid;

import java.util.List;
import java.util.Locale;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
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
//	private ReloadableResourceBundleMessageSource messageSource;
	
	/**
	 * 验证:  http://localhost:8080/HelloSpringMVC/valid?name=chen&age=35
	 * 		 http://localhost:8080/HelloSpringMVC/valid?name=chenchenchen&age=1&siteLanguage=en_US
	 * 		 http://localhost:8080/HelloSpringMVC/valid?name=chenchenchen&age=1&siteLanguage=zh_CN
	 */
	@ResponseBody
	@RequestMapping(value="/valid")
	public Map<String,Object> saveRegistration(@Valid User user, BindingResult result, Locale locale){
		
		Locale locale2 = LocaleContextHolder.getLocale();
        System.out.println("testi18n:" + messageSource.getMessage("user.id.null", null, locale));
        System.out.println("当前国际化:" + locale2 + ", " + locale);

		if(result.hasErrors()) {
	        Map<String,Object> map=new HashMap<String,Object>(); 
            Map<String,Object> data = new HashMap<String, Object>();
//	        for(FieldError err : result.getAllErrors()) {
//	        		err.getField();
//	        		err.getDefaultMessage();
//	        }
            FieldError fieldError= result.getFieldError();  
            System.out.println(fieldError.getDefaultMessage());  
              
            List<FieldError> list = result.getFieldErrors();  
            for (FieldError fieldError2 : list) {
                data.put(fieldError2.getField(), fieldError2.getDefaultMessage());
            }  
            List<ObjectError> ls = result.getAllErrors();  
            for (int i = 0; i < ls.size(); i++) {  
                System.out.println("error:"+ls.get(i).getDefaultMessage());  
            } 
	        map.put("code", "10004");
	        map.put("msg", "请求参数校验失败！！！");
	        map.put("data", data);
	        map.put("msgs","user.id.null");
	        map.put("msgs2","{user.id.null}");
	        return map;
		}

        Map<String,Object> map=new HashMap<String,Object>();
        map.put("code", "10001");
        map.put("msg", "请求参数校验成功！！！");
        return map;
	}
}
