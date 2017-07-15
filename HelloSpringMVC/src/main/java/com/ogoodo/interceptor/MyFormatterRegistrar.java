package com.ogoodo.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistrar;
import org.springframework.format.FormatterRegistry;

import com.ogoodo.valid.formatter.factory.MyPhoneNumberFormatAnnotationFormatterFactory;
import com.ogoodo.valid.formatter.factory.MyPhoneNumberFormatter;

public class MyFormatterRegistrar implements FormatterRegistrar {
    private String datePattern;

	@Autowired
    private ResourceBundleMessageSource messageSource;

    public MyFormatterRegistrar(String datePattern) {
        this.datePattern = datePattern;
    }

    	@Override
    public void registerFormatters(FormatterRegistry formatterRegistry) {
    		System.out.println("MyFormatterRegistrar");
    		MyPhoneNumberFormatAnnotationFormatterFactory annotationFormatterFactory = new MyPhoneNumberFormatAnnotationFormatterFactory();
    		annotationFormatterFactory.setMessageSource(messageSource);
    		formatterRegistry.addFormatterForFieldAnnotation(annotationFormatterFactory);
//    		MyPhoneNumberFormatter fmt = new MyPhoneNumberFormatter();
//    		fmt.setMessageSource(messageSource);
//    		formatterRegistry.addFormatter(fmt);
        // formatterRegistry.addFormatter(new DateFormatter(datePattern));
        //register more formatters here
    }
}
