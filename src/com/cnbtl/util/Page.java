package com.cnbtl.util;

import java.util.List;

/**
 * 该类用于返回记录给前端页面
 * 用于分页显示使用
 * @author Mrruan
 *
 * @param <T> T为数据库记录类型.
 * 
 * 内容:
 * 1.总记录条数,来自数据库
 * 2.每页的记录数,可以为默认.
 * 3.页数 = totalRowNum/pageRowNum (+1)
 * 4.从数据库拿出的记录数量
 * 5.当前页数
 * 包含方法：
 * 1.是否有上一页或者下一页(方法)
 * 2.获取当前页
 * 3.获取记录表
 * 4.获取总页数
 */
public class Page<T> {

	/**
	 * 每个参数带有默认值.
	 */
	//总记录条数
	private Integer totalRowNum = 9;
	//每页记录数
	private Integer pageRowNum = 9;
	//总共的页数
	private Integer totalPage 
		=(totalRowNum % pageRowNum == 0)?(totalRowNum /pageRowNum):(totalRowNum /pageRowNum + 1);
	
	//当前页的
	private List<T> list = null;
	//当前页数
	private Integer currentPage = 1;
	
	//构造方法
	public Page(){
		
	}
	/**
	 * 获取总记录数
	 * @return
	 */
	public Integer getTotalRowNum() {
		return totalRowNum;
	}

	/**
	 * 设置总记录数
	 * @param totalRowNum
	 */
	public void setTotalRowNum(Integer totalRowNum) {
		this.totalRowNum = totalRowNum;
	}

	/**
	 * 获取每页记录数
	 * @return
	 */
	public Integer getPageRowNum() {
		return pageRowNum;
	}

	/**
	 * 设置每页的记录数
	 * @param pageRowNum
	 */
	public void setPageRowNum(Integer pageRowNum) {
		this.pageRowNum = pageRowNum;
	}

	/**
	 * 获得总页数
	 * @return
	 */
	public Integer getTotalPage() {
		if(totalRowNum % pageRowNum != 0)
			totalPage = totalRowNum / pageRowNum + 1;
		else
			totalPage = totalRowNum / pageRowNum;
		return totalPage;
	}

	/**
	 * 设置总页数
	 * @param totalPage
	 */
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	/**
	 * 获取page中的所有记录列表
	 * @return
	 */
	public List<T> getList() {
		return list;
	}

	/**
	 * 设置当前页面的总记录数
	 * @param list
	 */
	public void setList(List<T> list) {
		this.list = list;
	}

	/**
	 * 获取当前页号
	 * @return
	 */
	public Integer getCurrentPage() {
		return currentPage;
	}

	/**
	 * 设置当前页号.
	 * @param currentPage
	 */
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	
	
	
	
	
	
}
