//package com.ogoodo.interceptor.test;
//
//import org.springframework.validation.AbstractBindingResult;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.MessageCodesResolver;
//import org.springframework.web.bind.ServletRequestDataBinder;
//
//public class MyServletRequestDataBinder extends ServletRequestDataBinder {
//
//
//
//
//public MyServletRequestDataBinder(Object target) {
//		super(target);
//		// TODO Auto-generated constructor stub
//	}
//
//public MyServletRequestDataBinder(Object target, String objectName) {
//		super(target, objectName);
//		// TODO Auto-generated constructor stub
//	}
//
//private MessageCodesResolver messageCodesResolver = new MyMessageCodesResolver();
//
//@Override
//public void initBeanPropertyAccess() {
//   super.initBeanPropertyAccess();
//   BindingResult bindingResult = super.getBindingResult();
//   if(bindingResult instanceof AbstractBindingResult) {
//       ((AbstractBindingResult)bindingResult).setMessageCodesResolver(messageCodesResolver);
//   }
//}
//
//@Override
//public void initDirectFieldAccess() {
//  super.initDirectFieldAccess();
//  BindingResult bindingResult = super.getBindingResult();
//  if(bindingResult instanceof AbstractBindingResult) {
//     ((AbstractBindingResult)bindingResult).setMessageCodesResolver(messageCodesResolver);
//    }
// }
//}