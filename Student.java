package com.sse4350.model;


public class Student {
	private int id;
	private String name;
	private String department;
	private double math;
	private double science;
	
	public Student() {
		super();
		
	}
	public Student(int id, String name, String department, double math, double science) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.math = math;
		this.science = science;
	}

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
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public double getMath() {
		return math;
	}
	public void setMath(double math) {
		this.math = math;
	}
	public double getScience() {
		return science;
	}
	public void setScience(double science) {
		this.science = science;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", math=" + math + ", science=" + science + "]";
	}
	
}
