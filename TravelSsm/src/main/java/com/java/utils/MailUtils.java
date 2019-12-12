package com.java.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



public class MailUtils {
	private String email;
	private String code;
	
	public MailUtils(String code,String eamil ) {
		this.email = eamil ;
		this.code = code;
	}
	
	public  void sendMail() {
		
		String serverHost = "smtp.163.com";
		String from = "nikolalee@163.com";
		String sCode = "leehao2017";
		
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", serverHost);
		properties.setProperty("mail.smtp.auth", "true");
		//创建连接对象javax.mail.Session
		Session session = Session.getDefaultInstance(properties,new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				
				return new PasswordAuthentication(from, sCode);
				
			}
		});
		
		
		//创建邮件对象javax.mail.Message
		
		Message msg = new MimeMessage(session);
		
		try {
			//设置发件人信息
			msg.setFrom(new InternetAddress(from));
			//设置收件人信息
			msg.setRecipient(RecipientType.TO, new InternetAddress(email));
			
			//设置邮件主题
			msg.setSubject("邮件激活『黑马旅游网』");
			//设置邮件内容
			String content = "<html><head></head><body>"
				+ "<h1>点击链接激活邮箱『黑马旅游网』:</h1>"
				+ "<a href='http://localhost:8080/TravelSsm/user/activate?code="+code+"'>"
				+ "http://localhost:8080/TravelSsm/user/activate?code="+code		
				+ "</a>"
				+"</body></html>";
			msg.setContent(content, "text/html;charset=utf-8");
			//发送邮件
			
			Transport.send(msg);
		
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		
	
		
	}
}
