package com.szwh.service;

import com.szwh.entity.Case;
import com.szwh.util.Page;


public interface CasePageService {

	/**
	 * 根据传入的当前页的页号,获取到page对象并返回.
	 * page中的主要内容为当前页面的记录列表
	 * 附加信息为当前页,下一页,总页,什么什么的.
	 * @param currentPage
	 * @return
	 */
	Page<Case> getPage(Integer currentPage);
	
	Page<Case> getPageByType(Integer currentPage,String type);
}
