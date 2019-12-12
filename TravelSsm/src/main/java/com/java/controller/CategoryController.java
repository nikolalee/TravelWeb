package com.java.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.bean.Category;
import com.java.serviceImpl.CategoryServiceImpl;
import com.java.utils.JacksonUtils;

@Controller
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryServiceImpl categoryService;
	/**
	 * 用于查询表中所有数据
	 * @param req
	 * @param res
	 */
	@RequestMapping("/findAll")
	public void findAll(HttpServletResponse res) {
		
		List<Category> list = categoryService.findAll();
		if(list != null) {
			JacksonUtils.writeValue(list,res);
		}
	}
	
	/**
	 * 用于查询表中所有数据,并以json格式返回
	 * @param req
	 * @param res
	 */
	@RequestMapping("/findAllAsJson")
	public void findAllAsJson(HttpServletResponse res) {
		String json = categoryService.findAllAsJson();
		res.setContentType("application/json;charset=utf-8");
		try {
			res.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
