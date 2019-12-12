package com.java.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.java.bean.Route;
import com.java.bean.RouteImg;
import com.java.bean.Seller;
@Repository
public interface DetailsDao {
	@Select("select * from tab_route where rid = #{rid}")
	Route getOne(int rid) ;
	@Select("select * from tab_route_img where rid = #{rid}")
	List<RouteImg> getImgList(int rid);
	@Select("select * from tab_seller where sid = #{sid}")
	Seller getSeller(int sid);
	
	
}
