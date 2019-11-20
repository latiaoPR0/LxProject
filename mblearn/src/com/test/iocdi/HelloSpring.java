package com.test.iocdi;

public class HelloSpring {
	private String name;
	
	public void show() {
		System.out.println("Hello "+ this.getName()+"!");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
