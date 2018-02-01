package com.cnbtl.dao;

import com.cnbtl.entity.User;

public interface UserDao {
	
	/**
	 * 通过id查询用户的信息
	 * @param id 用户的id号
	 * @return 一个用户对象
	 */
	User selectById(Integer id);
	
	
	/**
	 *  增加一个新用户
	 * @param user 用户实例
	 * @return 增加的条数,错误返回0
	 */
	Integer add(User user);
	
	/**
	 * 通过用户的id删除一个用户
	 * @param id
	 * @return 删除的记录条数 正常为1,删除失败返回0
	 */
	Integer deleteById(Integer id);
	
	/**
	 * 根据用户account查找用户
	 * @param account
	 * @return User的实例
	 */
	User selectByAccount(String account);
	
}
