package com.java.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.bean.Route;
import com.java.bean.RouteImg;
import com.java.bean.Seller;
import com.java.dao.DetailsDao;
import com.java.service.DetailsService;

@Service
public class DetailsServiceImpl implements DetailsService{
	@Autowired
	private DetailsDao details;
	
	@Override
	public Route getRoute(String rid) {
		int id = Integer.parseInt(rid);
		return details.getOne(id);
	}

	@Override
	public List<RouteImg> getRouteImg(String rid) {
		int id = Integer.parseInt(rid);
		return details.getImgList(id);
	}

	@Override
	public Seller getSeller(String sid) {
		int id = Integer.parseInt(sid);
		return details.getSeller(id);
	}

	

}
