package com.zhb.test2;

public abstract class AbstractClass implements IPerson{
	
	public void say(String str){
		System.out.println("hello");
	}
	
	public abstract String getName();
	
	public abstract String getTime();
	
	public void run(){
		System.out.println("running");
	}

}
