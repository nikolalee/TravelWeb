package com.java.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import com.java.bean.Route;
import com.java.utils.PageBeanDynamicSqlProvider;
@Repository
public interface PageBeanDao {
	@SelectProvider(type=PageBeanDynamicSqlProvider.class,method="count")
	int count(@Param("cid") int cid, @Param("rname")String rname) ;
	@SelectProvider(type=PageBeanDynamicSqlProvider.class,method="getList")
	List<Route> getList(@Param("pageLines")int pageLines,@Param("start") int start,@Param("cid") int cid, @Param("rname") String rname);
}
