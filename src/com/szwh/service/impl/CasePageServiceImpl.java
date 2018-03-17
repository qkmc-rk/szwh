package com.szwh.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.szwh.dao.CaseDao;
import com.szwh.entity.Case;
import com.szwh.service.CasePageService;
import com.szwh.util.Page;

@Service("casePageService")
public class CasePageServiceImpl implements CasePageService {

	@Autowired
	CaseDao caseDao;
	
	@Override
	public Page<Case> getPage(Integer currentPage) {
		Page<Case> page = new Page<>();
		//先将所有的记录数拿出来,偷懒之选,其实只需要获取some就可以了..
		List<Case> cases = caseDao.selectAll();
		//接着获取各种信息
		Integer totalRowNum = cases.size();
			Integer totalPage =(totalRowNum % page.getPageRowNum() == 0)?(totalRowNum / page.getPageRowNum()):(totalRowNum / page.getPageRowNum() + 1);//pageRowNum为已知条件,也可在这之前设置为某值,使用set方法
		
		int fromIndex = (currentPage-1) * page.getPageRowNum();
		int toIndex;
		if(fromIndex + page.getPageRowNum() < cases.size())
			toIndex = fromIndex + page.getPageRowNum();
		else
			toIndex = cases.size();
		
		//判断当前页的合理性
		//System.out.println(totalPage);
		if(currentPage < 1 || currentPage > totalPage)
			return null;
		List<Case> currentPageList = cases.subList(fromIndex, toIndex);
		//System.out.println(currentPageList);
		//该设置page的属性了.
		page.setCurrentPage(currentPage);
		page.setList(currentPageList);
		page.setTotalPage(totalPage);
		page.setTotalRowNum(totalRowNum);
		return page;
	}

	@Override
	public Page<Case> getPageByType(Integer currentPage,String type) {
		Page<Case> page = new Page<>();
		//先将所有的记录数拿出来,偷懒之选,其实只需要获取some就可以了..
		List<Case> cases = caseDao.selectByType(type);
		//接着获取各种信息
		Integer totalRowNum = cases.size();
			Integer totalPage =(totalRowNum % page.getPageRowNum() == 0)?(totalRowNum / page.getPageRowNum()):(totalRowNum / page.getPageRowNum() + 1);//pageRowNum为已知条件,也可在这之前设置为某值,使用set方法
		
		int fromIndex = (currentPage-1) * page.getPageRowNum();
		int toIndex;
		if(fromIndex + page.getPageRowNum() < cases.size())
			toIndex = fromIndex + page.getPageRowNum();
		else
			toIndex = cases.size();
		
		//判断当前页的合理性
		//System.out.println(totalPage);
		if(currentPage < 1 || currentPage > totalPage)
			return null;
		List<Case> currentPageList = cases.subList(fromIndex, toIndex);
		//System.out.println(currentPageList);
		//该设置page的属性了.
		page.setCurrentPage(currentPage);
		page.setList(currentPageList);
		page.setTotalPage(totalPage);
		page.setTotalRowNum(totalRowNum);
		return page;
	}

}
