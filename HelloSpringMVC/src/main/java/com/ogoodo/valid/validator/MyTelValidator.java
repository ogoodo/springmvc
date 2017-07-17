package com.ogoodo.valid.validator;

import javax.annotation.Resource;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.context.support.ResourceBundleMessageSource;

public class MyTelValidator implements ConstraintValidator<MyTel, String> {

    @Resource
    private ResourceBundleMessageSource messageSource;
    
    private MyTel myTel;
    
    @Override
    public void initialize(MyTel myTel) {
        this.myTel = myTel;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintContext) {
        boolean isValid;
        
        if(value != null && value.length() >= myTel.min()) {
            isValid = true;
        }
        else {
            isValid = false;
        }
        
        if(!isValid) {
            constraintContext.disableDefaultConstraintViolation();
            constraintContext.buildConstraintViolationWithTemplate(myTel.message()).addConstraintViolation();
        }
        return isValid;
    }

}
