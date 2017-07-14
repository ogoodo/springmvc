package com.ogoodo.valid;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

public class User {
	
	@NotNull
    @Size(min = 3, max = 10, message="用户名的长度应该在3和10之间")
	private String name;

	@Range(min = 10, max = 100)
	private int age;

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
