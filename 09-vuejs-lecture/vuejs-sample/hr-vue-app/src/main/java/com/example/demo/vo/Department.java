package com.example.demo.vo;

import org.apache.ibatis.type.Alias;

@Alias("Department")
public class Department {

	private int id;
	private String name;
	
	public Department() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
