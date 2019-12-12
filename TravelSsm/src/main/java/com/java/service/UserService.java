package com.java.service;

import com.java.bean.User;

public interface UserService {
	boolean register(User user);
	boolean activate(String code);
	User login(User user);
	User findByCode(String code);
	boolean updateStatus(User user) ;
}
