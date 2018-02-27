package com.szwh.service;

import java.util.List;

import com.szwh.entity.Case;

public interface CaseService {

	/**
	 * ��ȡ���еİ���
	 * @return ���а���
	 */
	List<Case> getAllCase();
	
	
	/**
	 * ����һ������
	 * @param case1 ���ж���
	 * @return ����ֵ,�Ƿ����Ӱ��гɹ�
	 */
	boolean saveOneCase(Case case1);

	/**
	 * ɾ��һ������,ͨ�����е�idֵ
	 * @param id
	 */
	boolean deleteOneCaseById(Integer id);
	
	/**
	 * ����һ������
	 * @param case1  ���е��޸ĺ���Ϣ
	 * @return �Ƿ��޸ĳɹ�
	 */
	boolean updateOneCase(Case case1);
	
	/**
	 * ����һ������,ͨ����idֵ������
	 * @param id id
	 * @return һ������(Case)��ʵ������
	 */
	Case selectOneCaseById(Integer id);


	List<Case> selectSomeCase(int start, int end);
	
	Integer plusClick(Integer id, Integer plusNum);
	
}
