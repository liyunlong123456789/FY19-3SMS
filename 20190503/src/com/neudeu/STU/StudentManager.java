package com.neudeu.STU;

public class StudentManager {
	public StudentManager() 
	{
		
	}
	
	public StudentManager(Integer id, String name, Integer age, String sex, String cid) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.Cid = cid;
	}
	
	@Override
	public String toString() {
		return "StudentManager [id=" + id + ", name=" + name + ", age=" + age + ", sex=" + sex + ", Cid=" + Cid + "]";
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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getCid() {
		return Cid;
	}
	public void setCid(String cid) {
		Cid = cid;
	}

	private Integer id;
	private String name;
	private Integer age;
	private String sex;
	private String Cid;
}
