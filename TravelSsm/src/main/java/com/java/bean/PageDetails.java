package com.java.bean;

import java.io.Serializable;
import java.util.List;

public class PageDetails implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String rname;
	private String price;
	private String count;
	private List<RouteImg> imgList;
	private Seller seller;
	private boolean favorite;
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
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public List<RouteImg> getImgList() {
		return imgList;
	}
	public void setImgList(List<RouteImg> imgList) {
		this.imgList = imgList;
	}
	public Seller getSeller() {
		return seller;
	}
	public void setSeller(Seller seller) {
		this.seller = seller;
	}
	public boolean isFavorite() {
		return favorite;
	}
	public void setFavorite(boolean isFavorite) {
		this.favorite = isFavorite;
	}
	
}
