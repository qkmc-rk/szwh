package com.cnbtl.service;

import com.cnbtl.entity.User;

public interface UserService {

	/**
	 * 用户登录方法
	 * @param username 用户名
	 * @param password 密码
	 * @return 成功返回User
	 */
	User login(String username,String password);
}
