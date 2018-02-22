package com.cnbtl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnbtl.dao.CaseDao;
import com.cnbtl.entity.Case;
import com.cnbtl.service.CaseService;

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
}
