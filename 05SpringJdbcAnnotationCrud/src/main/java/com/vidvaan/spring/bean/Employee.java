package com.vidvaan.spring.bean;

public class Employee {
	private int eid;
	private String email;
	private float esal;
	private String ename;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int eid, String email, float esal, String ename) {
		super();
		this.eid = eid;
		this.email = email;
		this.esal = esal;
		this.ename = ename;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public float getEsal() {
		return esal;
	}

	public void setEsal(float esal) {
		this.esal = esal;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", email=" + email + ", esal=" + esal + ", ename=" + ename + "]";
	}


}
