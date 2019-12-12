package com.java.utils;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class PageBeanDynamicSqlProvider {
	public String count(@Param("cid")int cid,@Param("rname")String rname) {
		return new SQL() {{
			SELECT("count(*)");
			FROM("tab_route");
			if(cid != 0) {
				WHERE("cid = #{cid}");
			}
			if(rname != null && rname !="" && !("null").equals(rname)) {
				WHERE("rname like #{rname}");
			}
		}
			
		}.toString();
	}
	
	public String getList(@Param("pageLines")int pageLines,@Param("start") int start,@Param("cid") int cid, @Param("rname") String rname) {
		return new SQL() {
			{
				SELECT("*");
				FROM("tab_route");
				if(cid != 0) {
					WHERE("cid = #{cid}");
				}
				if(rname != null && rname !="" && !("null").equals(rname)) {
					WHERE("rname like #{rname}");
				}
				LIMIT("#{start},#{pageLines}");
			}
		}.toString();
	}
}
