package com.java.service;

import java.util.List;

public interface PageBeanService<T> {
	int getPageNum(int cid,int pageLines, String rname);
	int getTotalLines(int cid, String rname);
	List<T> getList(int pageLines,int currentPage,int cid, String rname);
}
