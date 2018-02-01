package com.cnbtl.test;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cnbtl.dao.CaseDao;
import com.cnbtl.dao.UserDao;
import com.cnbtl.entity.Case;
import com.cnbtl.entity.User;

public class Test1 {
	
	ApplicationContext ctx = null;
	
	//初始化一下
	{
		ctx = new ClassPathXmlApplicationContext("root-context.xml");
	}
	
	@Test
	public void testUserDao() {
		UserDao userDao = (UserDao) ctx.getBean("userDao");
		User user = new User();
		user.setAccount("mrruan");
		user.setName("阮坤");
		user.setPassword("1314520");
		userDao.add(user);
		userDao.add(user);
		userDao.add(user);
		//System.out.println("delete -->" + userDao.deleteById(1));
		System.out.println("select -->" + userDao.selectById(2));
	}
	
	@Test
	public void testUserDao2() {
		UserDao userDao = (UserDao) ctx.getBean("userDao");
		User user = userDao.selectByAccount("mrruan");
		System.out.println(user);
	}
	
	@Test
	public void testCaseDao() {
		CaseDao caseDao = (CaseDao) ctx.getBean("caseDao");
		Case mycase = new Case();
		mycase.setTitle("昨日小傻瓜");
		mycase.setOrigin("rk个人中心");
		mycase.setEditor(2);
		mycase.setDate(new Timestamp(new Date().getTime()));
		mycase.setContent("<p>I am a good student</p><img src=\"http://jiaowu.sicau.edu.cn/photo/20140250.jpg\"/>");
		mycase.setClick(0);
		caseDao.insert(mycase);
		caseDao.insert(mycase);
		caseDao.insert(mycase);
		caseDao.insert(mycase);
		caseDao.insert(mycase);
		System.out.println("select-->" + caseDao.selectById(2));
		System.out.println("selectsome-->" + caseDao.selectSome(0, 3));
	}
}
