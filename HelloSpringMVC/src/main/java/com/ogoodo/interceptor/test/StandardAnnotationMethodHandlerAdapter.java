//package com.ogoodo.interceptor.test;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.web.bind.ServletRequestDataBinder;
//import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;
//
//// * 参考: https://stackoverflow.com/questions/4219740/spring-validation-error-generation
//public class StandardAnnotationMethodHandlerAdapter extends AnnotationMethodHandlerAdapter    {
//    @Override
//    protected ServletRequestDataBinder createBinder(HttpServletRequest request, Object target, String objectName) throws Exception {
//    MyServletRequestDataBinder dataBinder = new MyServletRequestDataBinder(target, objectName);
//    return dataBinder;
//   }
//}
//
