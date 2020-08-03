package com.courseinfo.course;

public class Enrollment {
	
	private String cId;
	private String sId;
	
	public Enrollment() {
		
	}

	public Enrollment(String cId, String sId) {
		super();
		this.cId = cId;
		this.sId = sId;
	}

	public String getcId() {
		return cId;
	}

	public void setcId(String cId) {
		this.cId = cId;
	}

	public String getsId() {
		return sId;
	}

	public void setsId(String sId) {
		this.sId = sId;
	}
	
	@Override
	public String toString() {
		return this.cId + " and " + this.sId;
	}
	
}
