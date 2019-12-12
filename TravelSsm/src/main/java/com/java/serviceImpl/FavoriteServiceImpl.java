package com.java.serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.bean.Favorite;
import com.java.bean.User;
import com.java.dao.FavoriteDao;
import com.java.service.FavoriteService;

@Service
public class FavoriteServiceImpl implements FavoriteService{
	@Autowired
	private FavoriteDao fav ;
	
	@Override
	public User getUser(String uname) {
		User user = fav.getUser(uname);
		return user;
	}

	@Override
	public boolean getFavorite(String uid, String rid) {
		int uid1 = Integer.parseInt(uid);
		int rid1 = Integer.parseInt(rid);
		System.out.println(rid1);
		Favorite fav2 = fav.getFavorite(rid1, uid1); 
		if(fav2 != null) {
			return true;
		}
		return false;
	}

	@Override
	public int getCount(String rid) {
		int rid1 = Integer.parseInt(rid);
		return fav.count(rid1);
	}

	@Override
	public boolean save(String rid, String uid) throws ParseException {
		int uid1 = Integer.parseInt(uid);
		int rid1 = Integer.parseInt(rid);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String date = dateFormat.format(new Date());
		System.out.println(date);
		return fav.save(rid1, uid1, date);
	}

}
