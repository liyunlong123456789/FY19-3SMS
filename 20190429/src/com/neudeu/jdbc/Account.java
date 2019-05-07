package com.neudeu.jdbc;
/*
 * javaBean
 */
public class Account {
	public Account() 
	{
		
	}
	
	public Account(Integer id, String name, double deposit) {
		super();
		this.id = id;
		this.name = name;
		this.deposit = deposit;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getDeposit() {
		return deposit;
	}

	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}
	
	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", deposit=" + deposit + "]";
	}

	private Integer id;
	private String name;
	private double deposit;

}
