package com.java.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.java.bean.User;
@Repository
public interface UserDao {
	@Select("select * from tra_user where username = #{username}")
	User findByUserName(String username);
	@Insert("insert  into tra_user(username,pwd,name,birthday,gender,telephone,email,status,code) values(#{username},#{pwd},#{name},#{birthday},#{gender},#{telephone},#{email},#{status},#{code})")
	void save(@Param("username")String username,@Param("pwd")String pwd,@Param("name")String name,@Param("birthday")String birthday,@Param("gender")String gender,@Param("telephone")String telephone,@Param("email")String email,@Param("status")String status,@Param("code")String code);
	@Select("select * from tra_user where code = #{code}")
	User findByCode(String code);
	@Update("update tra_user set status = 'Y' where uid = #{uid}")
	void updateStatus(User user) ;
	@Select("select * from tra_user where username=#{username} and pwd=#{pwd}")
	User findByNameAndPassword(@Param("username")String username,@Param("pwd")String pwd);
}
