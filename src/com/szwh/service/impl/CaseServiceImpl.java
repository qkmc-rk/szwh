package com.szwh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.szwh.dao.CaseDao;
import com.szwh.entity.Case;
import com.szwh.service.CaseService;

@Service("caseService")
public class CaseServiceImpl implements CaseService {

	@Autowired
	CaseDao caseDao;
	@Override
	public List<Case> getAllCase() {
		List<Case> cases = caseDao.selectAll();
		return cases;
	}
	@Override
	public boolean saveOneCase(Case case1) {
		if(caseDao.insert(case1) > 0)
			return true;
		return false;
	}
	@Override
	public boolean deleteOneCaseById(Integer id) {
		if(caseDao.deleteById(id) < 1)
			return false;
		return true;
	}
	@Override
	public boolean updateOneCase(Case case1) {
		if(caseDao.update(case1) < 1)
			return false;
		return true;
	}
	@Override
	public Case selectOneCaseById(Integer id) {
		return caseDao.selectById(id);
	}
	@Override
	public List<Case> selectSomeCase(int start, int end) {
		return caseDao.selectSome(start, end);
	}
	@Override
	public Integer plusClick(Integer id, Integer plusNum) {
		return caseDao.updateClickPlusOne(id, plusNum);
	}
	
	@Override
	public Integer updateCover(Integer id, String cover) {
		//1.首先找到数据库记录
		Case case1=null;
		
		try {
			case1 = caseDao.selectById(id);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("没有找到id=" + id + "的case记录");
			return -1;
		}
		//2.设置cover后更新记录
		case1.setCover(cover);
		
		return caseDao.update(case1);
	}
}
