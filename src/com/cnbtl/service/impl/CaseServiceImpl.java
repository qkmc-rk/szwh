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
		int end = caseDao.selectForCount();
		int start = 0;
		List<Case> cases = caseDao.selectSome(start, end);
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
	
}
