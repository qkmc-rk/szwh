package com.szwh.test;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.szwh.dao.CaseDao;
import com.szwh.dao.UserDao;
import com.szwh.entity.Case;
import com.szwh.entity.User;

public class Test1 {
	
	ApplicationContext ctx = null;
	
	//��ʼ��һ��
	{
		ctx = new ClassPathXmlApplicationContext("root-context.xml");
	}
	
	@Test
	public void testUserDao() {
		UserDao userDao = (UserDao) ctx.getBean("userDao");
		User user = new User();
		user.setAccount("mrruan");
		user.setName("����");
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
		mycase.setTitle("����Сɵ��");
		mycase.setOrigin("rk��������");
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
