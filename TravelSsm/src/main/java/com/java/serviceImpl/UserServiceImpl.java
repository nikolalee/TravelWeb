package com.java.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.bean.User;
import com.java.dao.UserDao;
import com.java.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao ;

	@Override
	public boolean register(User user) {
		
		User u = userDao.findByUserName(user.getUsername());
		if(u != null) {
			return false;
		}else {
			
			userDao.save(user.getUsername(),user.getPwd(),user.getName(),user.getBirthday(),user.getGender(),user.getTelephone(),user.getEmail(),user.getStatus(),user.getCode());
			return true;
		}
		
	}

	@Override
	public boolean activate(String code) {
		User user = userDao.findByCode(code);
		if(user != null) {
			user.setStatus("Y");
			userDao.save(user.getUsername(),user.getPwd(),user.getName(),user.getBirthday(),user.getGender(),user.getTelephone(),user.getEmail(),user.getStatus(),user.getCode());
			return true;
		}
		return false;
	}

	@Override
	public User login(User user) {
		User u = userDao.findByNameAndPassword(user.getUsername(),user.getPwd());
		
		return u;
	}

	@Override
	public User findByCode(String code) {
		return userDao.findByCode(code);
	}

	@Override
	public boolean updateStatus(User user) {
		userDao.updateStatus(user);
		return true;
	}

	

}
