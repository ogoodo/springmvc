package com.ogoodo.interceptor;

import java.util.Locale;

import javax.validation.MessageInterpolator;
import org.hibernate.validator.messageinterpolation.ResourceBundleMessageInterpolator;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.NoSuchMessageException;

/**
 * 解析出来的消息不对
 * 参考: https://stackoverflow.com/questions/4219740/spring-validation-error-generation
 * 可以参考:  http://jinnianshilongnian.iteye.com/blog/1879166
 * 这里消息不是用ResourceBundleMessageInterpolator类处理的， 不知道哪个类
 * @author chen
 *
 */
// public class MyMessageSourceMessageInterpolator extends ResourceBundleMessageInterpolator implements MessageInterpolator, MessageSourceAware, InitializingBean {
public class MyMessageSourceMessageInterpolator extends  ResourceBundleMessageInterpolator implements MessageSourceAware {

	@Autowired
	private MessageSource messageSource;
	
	@Override
	public String interpolate(String messageTemplate, Context context) {
	    try {
	        return messageSource.getMessage(messageTemplate, new Object[]{}, Locale.getDefault());
	    } catch (NoSuchMessageException e) {
	        return super.interpolate(messageTemplate, context);
	    }
	}
	
	@Override
	public String interpolate(String messageTemplate, Context context, Locale locale) {
		String msg = super.interpolate(messageTemplate, context, locale);
		return "cxbadd:" + msg;
	//    try {
	//        return messageSource.getMessage(messageTemplate, new Object[]{}, locale);
	//    } catch (NoSuchMessageException e) {
	//        return super.interpolate(messageTemplate, context, locale);
	//    }
	}
	
	@Override
	public void setMessageSource(MessageSource messageSource) {
	    this.messageSource = messageSource;
	}
	
//	@Override
//	public void afterPropertiesSet() throws Exception {
//	    if (messageSource == null) {
//	        throw new IllegalStateException("MessageSource was not injected, could not initialize "
//	                + this.getClass().getSimpleName());
//	    }
//	}
}
