package com.java.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.java.bean.Category;

@Repository
public interface CategoryDao {
	@Select("select * from tra_category")
	List<Category> findAll();
}
