package com.java.service;

import java.text.ParseException;

import com.java.bean.User;

public interface FavoriteService {
	User getUser(String uname) ;
	boolean getFavorite(String uid,String rid);
	int getCount(String rid);
	boolean save(String rid,String uid) throws ParseException;
}
