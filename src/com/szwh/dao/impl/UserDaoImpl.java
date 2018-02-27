package com.szwh.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.szwh.dao.UserDao;
import com.szwh.entity.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	JdbcTemplate jdbcTempalete;
	
	@Override
	public User selectById(Integer id) {
		String sql = "select * from t_user where id=?";
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
		User user = jdbcTempalete.queryForObject(sql, rowMapper, id);
		return user;
	}

	@Override
	public Integer add(User user) {
		String sql = "insert into t_user(name,account,password)values(?,?,?)";
		Integer rs = jdbcTempalete.update(sql, user.getName(),user.getAccount(),user.getPassword());
		return rs;
	}

	@Override
	public Integer deleteById(Integer id) {
		String sql = "delete from t_user where id=?";
		Integer rs =jdbcTempalete.update(sql, id);
		return rs;
	}

	@Override
	public User selectByAccount(String account) {
		String sql = "select * from t_user where account=?";
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
		User user = jdbcTempalete.queryForObject(sql, rowMapper, account);
		return user;
	}

}
