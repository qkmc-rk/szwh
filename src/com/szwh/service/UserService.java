package com.szwh.service;

import com.szwh.entity.User;

public interface UserService {

	/**
	 * �û���¼����
	 * @param username �û���
	 * @param password ����
	 * @return �ɹ�����User
	 */
	User login(String username,String password);
}
