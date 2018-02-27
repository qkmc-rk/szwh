package com.szwh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.szwh.dao.UserDao;
import com.szwh.entity.User;
import com.szwh.service.UserService;
import com.szwh.util.AppMD5Util;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Override
	public User login(String account, String password) {
		User user = userDao.selectByAccount(account);
		if(user == null)
			return null;
		else if(AppMD5Util.md5Password(password).equals(user.getPassword())){
			return user;
		}
		return null;
	}	
}
