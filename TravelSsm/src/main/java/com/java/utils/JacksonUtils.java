package com.java.utils;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonUtils {
	/**
	 * 该方法将被那些 想要将数据封装为json格式并返回到前端 的程序调用
	 */
	public static void writeValue(Object obj,HttpServletResponse res) {
		ObjectMapper mapper = new ObjectMapper();
		res.setContentType("application/json;charset=utf-8");
		try {
			mapper.writeValue(res.getOutputStream(),obj);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 想要序列化数据的程序可以调用此方法，从而简化代码量
	 * @return
	 */
	public static String writeValueAsStream(Object obj) {
		ObjectMapper mapper = new ObjectMapper();
		String value = "";
		try {
			value =  mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return value;
	}
}
