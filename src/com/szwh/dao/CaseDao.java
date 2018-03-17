package com.szwh.dao;

import java.util.List;

import com.szwh.entity.Case;

public interface CaseDao {
	
	/**
	 * ����һ���µ�case(����)
	 * @param mycase �ҵİ���
	 * @return �Ƿ����ɹ�,����1��ʾ�ɹ�,����0��ʾʧ��
	 */
	Integer insert(Case mycase);
	
	/**
	 * ���ҵ�ĳһ�������case
	 * @param id case��id
	 * @return ����һ��case����.
	 */
	Case selectById(Integer id);
	
	/**
	 *  ����һ�鰸��.
	 * @param index ���п�ʼ������ֵ
	 * @param end ��������������ֵ
	 * @return һ�鰸�е��б���ʽ
	 */
	List<Case> selectSome(Integer index,Integer end);
	
	/**
	 * �����ܼ�¼����
	 * @return ��¼����
	 */
	Integer selectForCount();
	
	
	List<Case> selectAll();
	
	List<Case> selectByType(String type);
	/**
	 * ���±���ĳһ�е�ֵ+һ������
	 * @param colName ����
	 * @param plusNum  Ҫ���ӵ�ֵ
	 * @return �ɹ����µ�����.
	 */
	Integer updateClickPlusOne(Integer id,Integer plusNum);
	
	/**
	 * ɾ��һ������,ͨ��id����ѯ�ð���
	 * @param id
	 * @return
	 */
	Integer deleteById(Integer id);
	
	/**
	 * ����һ������
	 * @param case1 Ҫ���µ�����
	 * @return ���µļ�¼����
	 */
	Integer update(Case case1);
	
	
}
