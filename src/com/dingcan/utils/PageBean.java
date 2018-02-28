package com.dingcan.utils;

import java.util.ArrayList;
import java.util.List;

public class PageBean<T> {
	private int pagesize = 10;
	private int total = 1;
	private int totalPage = 1;
	private int currentPage = 1;
	private int first = 1;
	private int last = 1; // [first,last)
	private List<T> list = new ArrayList();

	
	
	@Override
	public String toString() {
		return "PageBean [pagesize=" + pagesize + ", total=" + total
				+ ", totalPage=" + totalPage + ", currentPage=" + currentPage
				+ ", first=" + first + ", last=" + last + ", list=" + list
				+ "]";
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
		this.totalPage = total / pagesize;
		if (total % pagesize != 0) {
			this.totalPage = total / pagesize + 1;
		}
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getTotalPage() {
		return totalPage;
	}

	private void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getFirst() {
		return (currentPage - 1) * pagesize;
	}

	private void setFirst(int first) {
		this.first = first;
	}

	public int getLast() {
		return currentPage * pagesize;
	}

	private void setLast(int last) {
		this.last = last;
	}
	
}
