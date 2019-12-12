package com.java.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.bean.FrontBean;
import com.java.bean.Route;
import com.java.serviceImpl.PageBeanServiceImpl;
import com.java.utils.JacksonUtils;

@Controller
@RequestMapping("/page")
public class PageController {
	
	
	@Autowired
	private PageBeanServiceImpl pageBean ;
	
	@RequestMapping("/getPageBean")
	public void getPageBean(HttpServletRequest req,HttpServletResponse res) throws UnsupportedEncodingException {
		req.setCharacterEncoding("utf-8");
		String cidStr = req.getParameter("cid");
		String currentPageStr = req.getParameter("currentPage");
		String pageLinesStr = req.getParameter("pageLines");
		String rname1 = req.getParameter("rname");
		FrontBean<Route> frontBean = new FrontBean<Route>();
		//设置各项数据初始值
		int cid = 0;
		int currentPage = 1;
		int pageLines = 8;
		if(cidStr != null && cidStr != ""&& !"null".equals(cidStr)) {
			cid = Integer.parseInt(cidStr);
		}
		if(currentPageStr != null && currentPageStr != "" && !"null".equals(currentPageStr)) {
			currentPage = Integer.parseInt(currentPageStr);
		}
		if(pageLinesStr != null && pageLinesStr != "") {
			pageLines = Integer.parseInt(pageLinesStr);
		}
		String rname = null;
		//将url编码解码
		if(rname1 != null && rname1 != "" ) {
			
			rname = java.net.URLDecoder.decode(rname1,"utf-8");
		}
		//向数据库请求各项数据
		int totalLines = pageBean.getTotalLines(cid,rname);
		int pageNum = pageBean.getPageNum(cid,pageLines,rname);
		List<Route> list = pageBean.getList(pageLines, currentPage, cid,rname);
		//设置frontBean的各项数据
		frontBean.setCid(cid);
		frontBean.setCurrentPage(currentPage);
		frontBean.setPageLines(pageLines);
		
		frontBean.setPageNum(pageNum);
		frontBean.setTotalLines(totalLines);
		frontBean.setList(list);
		//发送数据给前端
		JacksonUtils.writeValue(frontBean,res);
	}
}
