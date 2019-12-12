package com.java.bean;

public class Favorite {
	private String rid;
	private String date;
	private String uid;
	public Favorite(String rid, String date, String uid) {
		super();
		this.rid = rid;
		this.date = date;
		this.uid = uid;
	}
	public Favorite() {
		super();
		
	}
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	@Override
	public String toString() {
		return "Favorite [rid=" + rid + ", date=" + date + ", uid=" + uid + "]";
	}
	
}
