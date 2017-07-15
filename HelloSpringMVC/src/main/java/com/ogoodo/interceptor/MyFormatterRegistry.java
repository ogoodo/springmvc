package com.ogoodo.interceptor;

import java.lang.annotation.Annotation;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.core.convert.converter.GenericConverter;
import org.springframework.format.AnnotationFormatterFactory;
import org.springframework.format.Formatter;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.Parser;
import org.springframework.format.Printer;

public class MyFormatterRegistry implements FormatterRegistry {


	@Override
	public void addFormatter(Formatter<?> formatter) {
		
	};

	@Override
	public void addFormatterForFieldType(Class<?> fieldType, Formatter<?> formatter) {
		
	};

	@Override
	public void addFormatterForFieldType(Class<?> fieldType, Printer<?> printer, Parser<?> parser) {
		
	};
	
	@Override
	public void addFormatterForFieldAnnotation(AnnotationFormatterFactory<? extends Annotation> annotationFormatterFactory) {
		
	};

	@Override
	public void addConverter(Converter<?, ?> converter) {
		
	}
	@Override
	public <S, T> void addConverter(Class<S> sourceType, Class<T> targetType, Converter<? super S, ? extends T> converter) {
		
	}
	@Override
	public void addConverter(GenericConverter converter) {
		
	}
	@Override
	public void addConverterFactory(ConverterFactory<?, ?> factory) {
		
	}
	@Override
	public void removeConvertible(Class<?> sourceType, Class<?> targetType) {
		
	}

}
