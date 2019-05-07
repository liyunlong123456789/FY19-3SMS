package com.neudeu.STU;

public class CourseManager {
	
	public CourseManager() {
		
	}
	
	public CourseManager(Integer cid, String cname) {
		Cid = cid;
		Cname = cname;
	}
	
	@Override
	public String toString() {
		return "CourseManager [Cid=" + Cid + ", Cname=" + Cname + "]";
	}

	public Integer getCid() {
		return Cid;
	}

	public void setCid(Integer cid) {
		Cid = cid;
	}

	public String getCname() {
		return Cname;
	}

	public void setCname(String cname) {
		Cname = cname;
	}

	private Integer Cid;
	private String Cname;
}
