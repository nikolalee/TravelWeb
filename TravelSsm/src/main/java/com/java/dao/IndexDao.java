package com.java.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.java.bean.Route;

@Repository
public interface IndexDao {
	
	@Select("select * from tab_favorite f,tab_route r where f.rid = r.rid limit 4")
	List<Route> getPopular();
	
	@Select("select * from tab_route order by rdate desc limit 4")
	List<Route> getNew();
	
	@Select("select * from tab_route where isThemeTour = 1 limit 4")
	List<Route> getTheme();
	
	@Select("select * from tab_route where cid = 5 limit 6")
	List<Route> getDemostic();
	
	@Select("select * from tab_route where cid = 8 limit 6")
	List<Route> getAboard();
	
}
