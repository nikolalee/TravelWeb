package com.java.utils;

import java.io.Serializable;

public class Info implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String code;
	private String data;
	private String msg;
	
	
	
	public Info() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Info(String code, String data, String msg) {
		super();
		this.code = code;
		this.data = data;
		this.msg = msg;
	}



	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
