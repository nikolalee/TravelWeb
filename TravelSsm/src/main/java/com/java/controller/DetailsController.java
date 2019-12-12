package com.java.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.bean.PageDetails;
import com.java.bean.Route;
import com.java.bean.RouteImg;
import com.java.bean.Seller;
import com.java.bean.User;
import com.java.serviceImpl.DetailsServiceImpl;
import com.java.serviceImpl.FavoriteServiceImpl;
import com.java.utils.JacksonUtils;

@Controller
@RequestMapping("/details")
public class DetailsController {
	
	
	@Autowired
	private DetailsServiceImpl details;
	@Autowired
	private FavoriteServiceImpl favo ;
	
	@RequestMapping("/getDetails")
	public void getDetails(HttpServletRequest req,HttpServletResponse res) {
		String rid = req.getParameter("rid");
		System.out.println(rid);
		//获取route对象
		Route route = details.getRoute(rid);
		String sid = route.getSid();
		//创建PageDetails对象，设置相应的值
		PageDetails page = new PageDetails();
		
		if(route != null) {
			page.setRname(route.getRname());
			page.setPrice(route.getPrice());
			
		}
		//设置收藏数
		int collect_num = favo.getCount(rid);
		page.setCount(String.valueOf(collect_num));
		//查询是否被收藏
		String uname = (String) req.getSession().getAttribute("username");
		User user = favo.getUser(uname);
		boolean isFavorite = false;
		if(user != null) {
			isFavorite = favo.getFavorite(user.getUid(), rid);
			
		}
		page.setFavorite(isFavorite);
		
		//获取RouteImg对象
		List<RouteImg> imgList = details.getRouteImg(rid);
		page.setImgList(imgList);
		
		//获取Seller对象
		Seller seller = details.getSeller(sid);
		page.setSeller(seller);
		
		//发送回客户端
		JacksonUtils.writeValue(page, res);
	}
	
	//收藏路线
	@RequestMapping("/save")
	public void save(HttpServletRequest req,HttpServletResponse res) throws ParseException {
		String rid = req.getParameter("rid");
		System.out.println(rid);
		String username = (String) req.getSession().getAttribute("username");
		res.setContentType("text/html;charset=utf-8");
		if(username == null) {
			try {
				res.getWriter().write("login");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			User user = favo.getUser(username);
			boolean flag = favo.save(rid, user.getUid());
			if(flag == true) {
				try {
					res.getWriter().write("ok");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
				
	
	}
	
	//获取收藏数
	@RequestMapping("/count")
	public void count(String rid ,HttpServletResponse res) {
		res.setContentType("text/html;charset=utf-8");
		int collect_num = favo.getCount(rid);
		System.out.println(collect_num);
		try {
			res.getWriter().write(String.valueOf(collect_num));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
