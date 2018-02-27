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
		//�Ƚ����еļ�¼���ó���,͵��֮ѡ,��ʵֻ��Ҫ��ȡsome�Ϳ�����..
		List<Case> cases = caseDao.selectAll();
		//���Ż�ȡ������Ϣ
		Integer totalRowNum = cases.size();
			Integer totalPage =(totalRowNum % page.getPageRowNum() == 0)?(totalRowNum / page.getPageRowNum()):(totalRowNum / page.getPageRowNum() + 1);//pageRowNumΪ��֪����,Ҳ������֮ǰ����Ϊĳֵ,ʹ��set����
		
		int fromIndex = (currentPage-1) * page.getPageRowNum();
		int toIndex;
		if(fromIndex + page.getPageRowNum() < cases.size())
			toIndex = fromIndex + page.getPageRowNum();
		else
			toIndex = cases.size() - 1;
		
		//�жϵ�ǰҳ�ĺ�����
		System.out.println(totalPage);
		if(currentPage < 1 || currentPage > totalPage)
			return null;
		List<Case> currentPageList = cases.subList(fromIndex, toIndex);
		
		//������page��������.
		page.setCurrentPage(currentPage);
		page.setList(currentPageList);
		page.setTotalPage(totalPage);
		page.setTotalRowNum(totalRowNum);
		return page;
	}

}
