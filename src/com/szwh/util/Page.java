package com.szwh.util;

import java.util.List;

/**
 * �������ڷ��ؼ�¼��ǰ��ҳ��
 * ���ڷ�ҳ��ʾʹ��
 * @author Mrruan
 *
 * @param <T> TΪ���ݿ��¼����.
 * 
 * ����:
 * 1.�ܼ�¼����,�������ݿ�
 * 2.ÿҳ�ļ�¼��,����ΪĬ��.
 * 3.ҳ�� = totalRowNum/pageRowNum (+1)
 * 4.�����ݿ��ó��ļ�¼����
 * 5.��ǰҳ��
 * ����������
 * 1.�Ƿ�����һҳ������һҳ(����)
 * 2.��ȡ��ǰҳ
 * 3.��ȡ��¼��
 * 4.��ȡ��ҳ��
 */
public class Page<T> {

	/**
	 * ÿ����������Ĭ��ֵ.
	 */
	//�ܼ�¼����
	private Integer totalRowNum = 9;
	//ÿҳ��¼��
	private Integer pageRowNum = 9;
	//�ܹ���ҳ��
	private Integer totalPage 
		=(totalRowNum % pageRowNum == 0)?(totalRowNum /pageRowNum):(totalRowNum /pageRowNum + 1);
	
	//��ǰҳ��
	private List<T> list = null;
	//��ǰҳ��
	private Integer currentPage = 1;
	
	//���췽��
	public Page(){
		
	}
	/**
	 * ��ȡ�ܼ�¼��
	 * @return
	 */
	public Integer getTotalRowNum() {
		return totalRowNum;
	}

	/**
	 * �����ܼ�¼��
	 * @param totalRowNum
	 */
	public void setTotalRowNum(Integer totalRowNum) {
		this.totalRowNum = totalRowNum;
	}

	/**
	 * ��ȡÿҳ��¼��
	 * @return
	 */
	public Integer getPageRowNum() {
		return pageRowNum;
	}

	/**
	 * ����ÿҳ�ļ�¼��
	 * @param pageRowNum
	 */
	public void setPageRowNum(Integer pageRowNum) {
		this.pageRowNum = pageRowNum;
	}

	/**
	 * �����ҳ��
	 * @return
	 */
	public Integer getTotalPage() {
		if(totalRowNum % pageRowNum != 0)
			totalPage = totalRowNum / pageRowNum + 1;
		else
			totalPage = totalRowNum / pageRowNum;
		return totalPage;
	}

	/**
	 * ������ҳ��
	 * @param totalPage
	 */
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	/**
	 * ��ȡpage�е����м�¼�б�
	 * @return
	 */
	public List<T> getList() {
		return list;
	}

	/**
	 * ���õ�ǰҳ����ܼ�¼��
	 * @param list
	 */
	public void setList(List<T> list) {
		this.list = list;
	}

	/**
	 * ��ȡ��ǰҳ��
	 * @return
	 */
	public Integer getCurrentPage() {
		return currentPage;
	}

	/**
	 * ���õ�ǰҳ��.
	 * @param currentPage
	 */
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	
	
	
	
	
	
}
