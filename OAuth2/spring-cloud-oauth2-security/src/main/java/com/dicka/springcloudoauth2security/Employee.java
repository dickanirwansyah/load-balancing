package com.dicka.springcloudoauth2security;

public class Employee {

	private String empId;
	private String name;
	private String position;
	private int salary;
	
	public Employee(){
		
	}
	
	public Employee(String empId, String name, String position, int salary){
		this.empId = empId;
		this.name = name;
		this.position = position;
		this.salary = salary;
	}
	
	public String getEmpId(){
		return empId;
	}
	
	public void setEmpId(String empId){
		this.empId = empId;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getPosition(){
		return position;
	}
	
	public void setPosition(String position){
		this.position = position;
	}
	
	public int getSalary(){
		return salary;
	}
	
	public void setSalary(int salary){
		this.salary = salary;
	}
}
