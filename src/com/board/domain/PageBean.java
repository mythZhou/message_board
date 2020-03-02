package com.board.domain;

import java.util.List;

public class PageBean<T> {
	private int page;//��ǰҳ��
	private int limit;//ÿҳ��ʾ�ļ�¼��
	private int totalCount;//�ܼ�¼��
	private int totalPage;//��ҳ��
	private List<T> list;//ÿҳ��ʾ�����ݵļ���
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "PageBean [page=" + page + ", limit=" + limit + ", totalCount=" + totalCount + ", totalPage=" + totalPage
				+ ", list=" + list + "]";
	}
	
}
