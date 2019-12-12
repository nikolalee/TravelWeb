package com.java.service;

import java.util.List;

import com.java.bean.Route;
import com.java.bean.RouteImg;
import com.java.bean.Seller;

public interface DetailsService {
	Route getRoute(String rid);
	List<RouteImg> getRouteImg(String rid);
	Seller getSeller(String sid);
	
}
