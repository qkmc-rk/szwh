package com.szwh.service;

import com.szwh.entity.Case;
import com.szwh.util.Page;


public interface CasePageService {

	/**
	 * ���ݴ���ĵ�ǰҳ��ҳ��,��ȡ��page���󲢷���.
	 * page�е���Ҫ����Ϊ��ǰҳ��ļ�¼�б�
	 * ������ϢΪ��ǰҳ,��һҳ,��ҳ,ʲôʲô��.
	 * @param currentPage
	 * @return
	 */
	Page<Case> getPage(Integer currentPage);
	
	Page<Case> getPageByType(Integer currentPage,String type);
}
