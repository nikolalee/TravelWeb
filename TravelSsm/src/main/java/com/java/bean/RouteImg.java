package com.java.bean;

public class RouteImg {
	private String rgid;
	private String rid;
	private String bigPic;
	private String smallPic;
	public RouteImg() {
		super();
		
	}
	public RouteImg(String rgid, String rid, String bigPic, String smallPic) {
		super();
		this.rgid = rgid;
		this.rid = rid;
		this.bigPic = bigPic;
		this.smallPic = smallPic;
	}
	public String getRgid() {
		return rgid;
	}
	public void setRgid(String rgid) {
		this.rgid = rgid;
	}
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public String getBigPic() {
		return bigPic;
	}
	public void setBigPic(String bigPic) {
		this.bigPic = bigPic;
	}
	public String getSmallPic() {
		return smallPic;
	}
	public void setSmallPic(String smallPic) {
		this.smallPic = smallPic;
	}
	@Override
	public String toString() {
		return "RouteImg [rgid=" + rgid + ", rid=" + rid + ", bigPic=" + bigPic + ", smallPic=" + smallPic + "]";
	}
	

}
