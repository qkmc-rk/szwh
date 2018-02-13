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

	//总记录条数
	private Integer totalRowNum;
	//每页记录数
	private Integer pageRowNum;
	//总共的页数
	private Integer totalPageNum;
	
	private List<T> list;
	//当前页数
	private Integer currentPageNum;
	
	
	
	
}
