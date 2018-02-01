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
		int start = 1;
		List<Case> cases = caseDao.selectSome(start, end);
		return cases;
	}

	
}
