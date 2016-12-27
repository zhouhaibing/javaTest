package com.zhb.test3;

import com.alibaba.fastjson.JSON;

public class Person {
	private long id;
	private String name;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString(){
		System.out.print("hello");
		return JSON.toJSONString(this);
	}
	

}
