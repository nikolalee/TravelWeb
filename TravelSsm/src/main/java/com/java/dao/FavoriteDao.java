package com.java.dao;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.java.bean.Favorite;
import com.java.bean.User;
@Repository
public interface FavoriteDao {
	@Select("select * from tra_user where username = #{uname}")
	User getUser(String uname);
	@Select("select * from tab_favorite where rid = #{rid} and uid = #{uid}")
	Favorite getFavorite(@Param("rid")int rid,@Param("uid")int uid);
	@Select("select count(*) from tab_favorite where rid = #{rid}")
	int count(int rid);
	@Insert("insert into tab_favorite(rid,uid,date) values(#{rid},#{uid},#{date})")
	boolean save(@Param("rid")int rid,@Param("uid")int uid,@Param("date")String date);
}
