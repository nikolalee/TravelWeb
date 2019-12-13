package com.java.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.bean.User;
import com.java.serviceImpl.UserServiceImpl;
import com.java.utils.CheckCodeUtils;
import com.java.utils.Info;
import com.java.utils.JacksonUtils;
import com.java.utils.MailUtils;
import com.java.utils.UuidUtils;

@Controller
@RequestMapping(path="/user")
public class UserController {
	
	@Autowired
	private UserServiceImpl userService;
	@Autowired
	private CheckCodeUtils checkcode;
	
	
	//验证码功能
	@RequestMapping("/checkCode")
	public void checkCode(HttpServletRequest req,HttpServletResponse res) {
		res.setContentType("image/jpg");
		
		HttpSession session = req.getSession();
		session.setMaxInactiveInterval(60);
		try {
			checkcode.sendCheckCode(res.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		String str = checkcode.getCheckCode();
		session.setAttribute("checkCode", str);
	}
	
	//登录功能
	@RequestMapping("/login")
	public void login(User user,HttpServletRequest req, HttpServletResponse res){
//			System.out.println(user);
			
			res.setContentType("text/html; charset=UTF-8");
			Info info = new Info();
			
			//校验验证码
			HttpSession session = req.getSession();
			String code = req.getParameter("check");
			String sessionCode = (String) session.getAttribute("checkCode");
//			System.out.println(code+" "+sessionCode);
			if(sessionCode != null && sessionCode.equalsIgnoreCase(code)) {
				
				//调用userService中的login方法
				User u = userService.login(user);
				//对返回结果进行判断及处理
				if(u == null) {
					//返回对象为空时
					info.setCode("0");
					info.setMsg("用户名或密码错误");
				}else {
					//返回对象不为空时
					if("Y".equals(u.getStatus())) {
						//邮箱已激活
						info.setCode("1");
						info.setMsg("登录成功");
						session.setAttribute("username", user.getUsername());
						
					}else {
						//邮箱未激活
						info.setCode("0");
						info.setMsg("邮箱还未验证。请先登录邮箱进行验证");
					}
				}
			}else {
				//验证码错误
				info.setCode("0");
				info.setMsg("验证码错误");
			}
			
			//返回数据到客户端
			JacksonUtils.writeValue(info, res);
		}
	
	
	//注册功能
	@RequestMapping("/register")
	public void register(User user ,HttpServletRequest req, HttpServletResponse res) {
			System.out.println(user);
		
			String checkCode = req.getParameter("check");
			String sessionCode = (String) req.getSession().getAttribute("checkCode");
			System.out.println(checkCode);
			System.out.println(sessionCode);
			Info info = new Info();
			res.setContentType("text/html;charset=utf-8");
			//校验验证码
			if(checkCode != null && checkCode.equalsIgnoreCase(sessionCode)) {
				//获取表单数据
				try {
					req.setCharacterEncoding("utf-8");
				} catch (UnsupportedEncodingException e1) {
					e1.printStackTrace();
				}
//				Map<String,String[]> map = req.getParameterMap();
//				User user = new User();
//				try {
//					BeanUtils.populate(user, map);
//				} catch (IllegalAccessException e) {
//					e.printStackTrace();
//				} catch (InvocationTargetException e) {
//					e.printStackTrace();
//				}
				//设置激活码及状态码
				String code = UuidUtils.getUuid();
				user.setCode(code);
				user.setStatus("N");
				//调用注册方法
				boolean flag = userService.register(user);
				System.out.println(flag);
				if(flag) {
					info.setCode("1");
					info.setMsg("注册成功");
					
					//发送激活邮件
					String email = user.getEmail();
					MailUtils mail = new MailUtils(code,email);
					mail.sendMail();
					
				}else {
					info.setCode("0");
					info.setMsg("注册失败。请稍后再次尝试");
				}
			}else {
				info.setCode("0");
				info.setMsg("验证码错误");
				
				
			}
			//返回数据到客户端
			JacksonUtils.writeValue(info, res);
		}
	
	//邮件激活功能
	@RequestMapping("/activate")
	public void activate(String code, HttpServletResponse response) {
		User user = userService.findByCode(code);
		String msg;
		response.setContentType("text/html; charset=UTF-8");
		if(user != null) {
			boolean flag =  userService.updateStatus(user);
			if(flag != false) {
				msg = "<p>邮箱激活成功。请到登录页面登录<a href ='/TravelSsm/html/login.html' >点击跳转登录页面</a></p>";
			}else {
				msg = "邮箱验证失败";
			}
			
		}else {
			msg = "邮箱验证失败";
		}
		
		try {
			response.getWriter().write(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 返回用户名，用于登录后显示用户名
	 */
	@RequestMapping("/getUser")
	public void getUser(HttpServletRequest req, HttpServletResponse res) {
		
		res.setContentType("application/json; charset=UTF-8");
		Object username = req.getSession().getAttribute("username");
		//返回数据到客户端
		JacksonUtils.writeValue(username, res);
	}
	
	
	//退出登录功能
	@RequestMapping("/exit")
	public void exit(HttpServletRequest request, HttpServletResponse response){
		//清空session
		request.getSession().invalidate();
		//转到login页面
		try {
			response.sendRedirect("/TravelSsm/index.html");
		} catch (IOException e) {
			e.printStackTrace();
		}
}
}
