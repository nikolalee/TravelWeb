package com.java.service;

import java.util.List;

import com.java.bean.Category;

public interface CategoryService {
	List<Category> findAll();
	String findAllAsJson();
}
