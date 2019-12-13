package com.java.service;

import java.util.List;

import com.java.bean.Route;

public interface IndexService {
	List<Route> getPopular();
	List<Route> getNew();
	List<Route> getTheme();
	List<Route> getDomestic();
	List<Route> getAboard();
}
