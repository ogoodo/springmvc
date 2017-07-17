package com.ogoodo.valid.validator;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=MyMobileValidator.class)
public @interface MyMobile {

    int min() default 0;
    
    String pattern() default "defaultPattern";

    String message();

    Class<?>[] groups() default {};
    
    Class<? extends Payload>[] payload() default {};

}
