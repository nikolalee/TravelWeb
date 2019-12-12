package com.java.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Component;

@Component("checkCode")
public class CheckCodeUtils {
	
	private  int height = 40;
	private  int width = 100;
	private  String str = "";
	
	public  void sendCheckCode(OutputStream output) {
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		g.setColor(Color.pink);
		g.fillRect(0, 0, width, height);
		Random ran = new Random();
		g.setColor(Color.black);
		g.setFont(new Font("微软雅黑",Font.PLAIN,30));
//		char ch;
//		for(int i = 0;i < 5;i++) {
//			
//			ch = charList.charAt(ran.nextInt(charList.length()));
//			g.drawString(ch+"", width/4 * i + 10, height/2 + 6);
//		}
		getString();
		g.drawString(str, 10, height/2 + 12);
		
		g.setColor(Color.blue);
		
		int x1 = 0,x2 = 0;
		int y1 = 0,y2 = 0;
		
		for(int i = 0;i < 8;i++) {
			
			x1 = ran.nextInt(width);
			y1 = ran.nextInt(height);
			x2 = ran.nextInt(width);
			y2 = ran.nextInt(height);
			
			g.drawLine(x1, y1, x2, y2);
			
		}
		
		try {
			ImageIO.write(image, "jpg", output);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public  void getString() {
		str = "";
		String charList = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm0123456789";
		Random ran = new Random();
		for(int i = 0;i < 4;i++) {
			str = str + charList.charAt(ran.nextInt(charList.length()));
		}
	}
	
	public  String getCheckCode() {
		return str;
	}
}
