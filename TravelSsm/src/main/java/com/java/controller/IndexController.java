package com.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.bean.Route;
import com.java.serviceImpl.IndexServiceImpl;

@RequestMapping("/index")
@ResponseBody
@Controller
public class IndexController {
	
	@Autowired
	IndexServiceImpl indexService;
	
	@RequestMapping("/getPopular")
	public List<Route> getPopular() {
		return indexService.getPopular();
	}
	
	@RequestMapping("/getNew")
	public List<Route> getNew() {
		return indexService.getNew();
	}
	
	@RequestMapping("/getTheme")
	public List<Route> getTheme() {
		return indexService.getTheme();
	}
	
	@RequestMapping("/getDomestic")
	public List<Route> getDomestic() {
		return indexService.getDomestic();
	}
	
	@RequestMapping("/getAboard")
	public List<Route> getAboard() {
		return indexService.getAboard();
	}
}
