package com.ogoodo.interceptor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.Formatter;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;  
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.ogoodo.valid.formatter.factory.MyPhoneNumberFormatAnnotationFormatterFactory;
import com.ogoodo.valid.formatter.factory.MyPhoneNumberFormatter;  
  
/**
 * 作用: http://blog.csdn.net/cloume/article/details/48439429
 * @author chen
 */
// 效果同: <context:component-scan base-package="com.ogoodo.valid"/>
@ComponentScan(basePackages = {"com.ogoodo.valid"})
@Configuration // @Configuration, this will let spring know this contains bean definitions
@EnableWebMvc // @EnableWebMVC 效果同 <mvc:annotation-driven/>
public class MyWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {  

	@Autowired
    private ResourceBundleMessageSource messageSource;
	
	// 测试可以 http://localhost:8080/HelloSpringMVC/logintest 
	// 会重定向到 http://localhost:8080/HelloSpringMVC/helloworld.jsp
	// <mvc:view-controller path="/" view-name="home"/>
    @Override  
    public void addViewControllers(ViewControllerRegistry registry){  
        registry.addViewController("/logintest").setViewName("helloworld");  
    }  
    
    @Override
    public void addFormatters(FormatterRegistry registry) {
//		MyPhoneNumberFormatter fmt = new MyPhoneNumberFormatter();
//		fmt.setMessageSource(messageSource);
//		registry.addFormatter(fmt);
		// registry.addFormatter((Formatter<?>) new MyPhoneNumberFormatAnnotationFormatterFactory());
        // Add formatters and/or converters
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    		System.out.println("==========================消息转换:configureMessageConverters");
    }
//    @Override
//    public void validate(Object target, Errors errors) {
//    	
//    }
//    @Bean
//    public FormattingConversionService conversionService() {
//
//        // Use the DefaultFormattingConversionService but do not register defaults
//        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService(false);
//
//        // Ensure @NumberFormat is still supported
//        conversionService.addFormatterForFieldAnnotation(new NumberFormatAnnotationFormatterFactory());
//
//        // Register date conversion with a specific global format
//        DateFormatterRegistrar registrar = new DateFormatterRegistrar();
//        registrar.setFormatter(new DateFormatter("yyyyMMdd"));
//        registrar.registerFormatters(conversionService);
//
//        return conversionService;
//    }
} 
