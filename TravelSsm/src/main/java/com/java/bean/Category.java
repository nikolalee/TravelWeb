package com.java.bean;

import java.io.Serializable;

public class Category implements Serializable{
	/**
	 * 该bean是用于对应数据库中category表
	 */
	private static final long serialVersionUID = 1L;
	private String cid;
	private String cname;
	
	
	public Category() {
		super();
		
	}
	
	
	
	public Category(String cid, String cname) {
		super();
		this.cid = cid;
		this.cname = cname;
	}



	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}



	@Override
	public String toString() {
		return "Category [cid=" + cid + ", cname=" + cname + "]";
	}

	
}
