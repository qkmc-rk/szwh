package com.cnbtl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnbtl.dao.UserDao;
import com.cnbtl.entity.User;
import com.cnbtl.service.UserService;
import com.cnbtl.util.AppMD5Util;

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
