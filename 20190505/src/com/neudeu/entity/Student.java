package com.neudeu.entity;

import java.io.Serializable;

/*
 * —ß…˙¿‡
 */
public class Student implements Serializable
{

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String sId, String sName, Integer sAge, String sSex) {
		super();
		this.sId = sId;
		this.sName = sName;
		this.sAge = sAge;
		this.sSex = sSex;
	}
	
	@Override
	public String toString() {
		return "Student [sId=" + sId + ", sName=" + sName + ", sAge=" + sAge + ", sSex=" + sSex + "]";
	}
	public String getsId() {
		return sId;
	}
	public void setsId(String sId) {
		this.sId = sId;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public Integer getsAge() {
		return sAge;
	}
	public void setsAge(Integer sAge) {
		this.sAge = sAge;
	}
	public String getsSex() {
		return sSex;
	}
	public void setsSex(String sSex) {
		this.sSex = sSex;
	}

	private String sId;
	private String sName;
	private Integer sAge;
	private String sSex;
}
