package com.neudeu.entity;
/*
 * øŒ≥Ã¿‡
 */
public class Course {
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Course(Integer cId, String cName) {
		super();
		this.cId = cId;
		this.cName = cName;
	}
	
	public Integer getcId() {
		return cId;
	}

	public void setcId(Integer cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}
	
	@Override
	public String toString() {
		return "Course [cId=" + cId + ", cName=" + cName + "]";
	}

	private Integer cId;
	private String cName;
		
}
