package com.szwh.dao;

import com.szwh.entity.User;

public interface UserDao {
	
	/**
	 * ͨ��id��ѯ�û�����Ϣ
	 * @param id �û���id��
	 * @return һ���û�����
	 */
	User selectById(Integer id);
	
	
	/**
	 *  ����һ�����û�
	 * @param user �û�ʵ��
	 * @return ���ӵ�����,���󷵻�0
	 */
	Integer add(User user);
	
	/**
	 * ͨ���û���idɾ��һ���û�
	 * @param id
	 * @return ɾ���ļ�¼���� ����Ϊ1,ɾ��ʧ�ܷ���0
	 */
	Integer deleteById(Integer id);
	
	/**
	 * �����û�account�����û�
	 * @param account
	 * @return User��ʵ��
	 */
	User selectByAccount(String account);
	
}
