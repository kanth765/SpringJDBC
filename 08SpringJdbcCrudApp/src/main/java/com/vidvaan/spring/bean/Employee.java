package com.vidvaan.spring.bean;

public class Employee {

	private int eid;
	private String ename;
	private float esal;
	private String email;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int eid, String ename, float esal, String email) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.esal = esal;
		this.email = email;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public float getEsal() {
		return esal;
	}

	public void setEsal(float esal) {
		this.esal = esal;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", esal=" + esal + ", email=" + email + "]";
	}

}
