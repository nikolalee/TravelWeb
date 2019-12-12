package com.java.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.bean.Route;
import com.java.dao.PageBeanDao;
import com.java.service.PageBeanService;

@Service
public class PageBeanServiceImpl implements PageBeanService<Route>{
	@Autowired
	private PageBeanDao pageBeanDao;
	
	@Override
	public int getPageNum(int cid,int pageLines,String rname) {
		String rname2 = null;
		if(rname != null && rname !="" && !("null").equals(rname) ) {
			
			rname2 = "%"+rname+"%";
		}
		int total =  pageBeanDao.count(cid,rname2);
		int num = total % pageLines > 0 ? total / pageLines + 1: total / pageLines;
		return num;
	}

	@Override
	public int getTotalLines(int cid,String rname) {
		String rname2 = null;
		if(rname != null && rname !="" && !("null").equals(rname) ) {
			
			rname2 = "%"+rname+"%";
		}
		return pageBeanDao.count(cid,rname2);
	}

	@Override
	public List<Route> getList(int pageLines, int currentPage, int cid,String rname) {
//		System.out.println("cid:"+cid);
//		System.out.println("rname:"+rname);
		int start = (currentPage - 1)* pageLines;
		String rname2 = null;
		if(rname != null && rname !="" && !("null").equals(rname) ) {
			
			rname2 = "%"+rname+"%";
		}
//		System.out.println("rname1:"+rname2);
		List<Route> list = pageBeanDao.getList(pageLines, start, cid,rname2);
//		System.out.println(list);
		return list;
	}

}
