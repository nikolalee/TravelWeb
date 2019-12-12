package com.java.bean;

import java.io.Serializable;

public class Route implements Serializable{
	/**
	 *该bean用于接收route表查询的数据
	 */
	private static final long serialVersionUID = 1L;
	private String rid;
	private String rname;
	private String price;	
	private String routeIntroduce;
	private String rflag;
	private String rdate;
	private String isThemeTour;
	private String count;
	private String cid;
	private String rimage;
	private String sid;
	private String sourceId;
	public Route() {
		super();
		
	}
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getRouteIntroduce() {
		return routeIntroduce;
	}
	public void setRouteIntroduce(String routeIntroduce) {
		this.routeIntroduce = routeIntroduce;
	}
	public String getRflag() {
		return rflag;
	}
	public void setRflag(String rflag) {
		this.rflag = rflag;
	}
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	public String getIsThemeTour() {
		return isThemeTour;
	}
	public void setIsThemeTour(String isThemeTour) {
		this.isThemeTour = isThemeTour;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getRimage() {
		return rimage;
	}
	public void setRimage(String rimage) {
		this.rimage = rimage;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSourceId() {
		return sourceId;
	}
	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}
	@Override
	public String toString() {
		return "Route [rid=" + rid + ", rname=" + rname + ", price=" + price + ", cid=" + cid + "]";
	}
	
	
}
