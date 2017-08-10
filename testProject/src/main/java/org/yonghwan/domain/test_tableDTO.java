package org.yonghwan.domain;

public class test_tableDTO {
	private String name;
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
	@Override
	public String toString() {
		return "test_tableDTO [name=" + name + ", age=" + age + "]";
	}
	
}
