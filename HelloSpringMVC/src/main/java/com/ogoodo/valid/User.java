package com.ogoodo.valid;

import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.number.PercentFormatter;

import com.ogoodo.valid.formatter.factory.MyDateFormat;
import com.ogoodo.valid.formatter.factory.MyPhoneNumberFormat;
import com.ogoodo.valid.formatter.factory.MyPhoneNumberModel;
import com.ogoodo.valid.validator.MyMin;
import com.ogoodo.valid.validator.MyMobile;
import com.ogoodo.valid.validator.MyTel;

public class User {
	
	@NotNull
    @Size(min = 3, max = 10, message="{my.user.name.null}")
	private String name;

	@Range(min = 10, max = 100, message = "{my.user.age}")
	private int age;

	private PercentFormatter xx;
	// 测试自定义验证
    // @NotNull(message="{user.birthday.null}")  
    // @Past(message="{user.birthday}") // 这个是验证过去时间
    @MyDateFormat //(message="{user.birthday.error}") 
    private Date birthday;//生日  

	// 测试默认验证
    @DateTimeFormat(pattern="yyyy-MM-dd")
//    @Past(message="{user.regdate.error}")
//    @Future(message = "{user.regdate.error}")
    // @DateTimeFormat(pattern="yyyy-MM-dd", message="{user.reg.error}")  
    private Date regdate;//注册时间 
    
    @MyPhoneNumberFormat(min = 8, max = 9, message="{user.phone.error}")
    @MyTel(message="{my.user.tel}", min=3)
    private MyPhoneNumberModel phone;
  
    @MyMobile(message="{my.user.mymobile}", min=3, pattern="XXX?-XXXXXXX?")
    private String mobile;

    @MyMin(message="{my.user.min}", min=3)
    private String mymin;
    
    public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

 
	public MyPhoneNumberModel getPhone() {
		return phone;
	}
	public void setPhone(MyPhoneNumberModel phone) {
		this.phone = phone;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regDate) {
		this.regdate = regDate;
	}
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
