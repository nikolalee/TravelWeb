package com.java.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.bean.Route;
import com.java.dao.IndexDao;
import com.java.service.IndexService;

@Service
public class IndexServiceImpl implements IndexService{
	
	@Autowired
	private IndexDao indexDao;
	
	@Override
	public List<Route> getPopular() {
		return indexDao.getPopular();
	}

	@Override
	public List<Route> getNew() {
		return indexDao.getNew();
	}

	@Override
	public List<Route> getTheme() {
		return indexDao.getTheme();
	}

	@Override
	public List<Route> getDomestic() {
		return indexDao.getDemostic();
	}

	@Override
	public List<Route> getAboard() {
		return indexDao.getAboard();
	}

}
