package com.java.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.bean.Category;
import com.java.dao.CategoryDao;
import com.java.service.CategoryService;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryDao categoryDao ;
	
	@Override
	public List<Category> findAll() {
		
		return categoryDao.findAll();
	}
	
	@Override
	public String findAllAsJson() {
		@SuppressWarnings("resource")
		//建立jedis连接池
		JedisPool jedisPool = new JedisPool("localhost",6379);
		//获取jedis对象
		Jedis jedis = jedisPool.getResource();
		//从redis中获取数据
		String category = jedis.get("category");
		//若redis中不存在数据
		if(category == null || category == "") {
			System.out.println("缓存中不存在数据，从数据库中获取。。。");
			//从数据库中获取数据
			List<Category> list = categoryDao.findAll();
			ObjectMapper mapper = new ObjectMapper();
			
			try {
				//将数据转为json格式
				category = mapper.writeValueAsString(list);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			//将json数据存入redis中
			jedis.set("category",category);
			//返回jeids连接
			jedis.close();
		}
		return category;
	}

}
