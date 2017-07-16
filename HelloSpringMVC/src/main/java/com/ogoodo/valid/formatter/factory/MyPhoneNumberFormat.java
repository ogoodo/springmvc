package com.ogoodo.valid.formatter.factory;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
// @Constraint(validatedBy = MyPhoneNumberModel.class) 参考: Configuring Custom Constraints http://docs.spring.io/spring-framework/docs/4.2.4.RELEASE/spring-framework-reference/html/validation.html#validation-beanvalidation-overview
public @interface MyPhoneNumberFormat {

	String message() default "{com.ogoodo.valid.formatter.factory.MyPhoneNumberFormat.message}";
	Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    Age age() default Age.YOUNG;
    public enum Age {
        YOUNG,
        WONDERING,
        OLD
    }
}