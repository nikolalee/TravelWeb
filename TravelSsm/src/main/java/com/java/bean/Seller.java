package com.java.bean;

public class Seller {
	private String sid;
	private String sname;
	private String consphone;
	private String address;
	public Seller() {
		super();
		
	}
	public Seller(String sid, String sname, String consphone, String address) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.consphone = consphone;
		this.address = address;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getConsphone() {
		return consphone;
	}
	public void setConsphone(String consphone) {
		this.consphone = consphone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Seller [sid=" + sid + ", sname=" + sname + ", consphone=" + consphone + ", address=" + address + "]";
	}
	
}
