package com.szwh.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.szwh.dao.CaseDao;
import com.szwh.dao.CaseException;
import com.szwh.entity.Case;

@Repository("caseDao")
public class CaseDaoImpl implements CaseDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Integer insert(Case mycase) {
		String sql = "insert into t_case(type,title,editor,origin,date,click,content)values(?,?,?,?,?,?,?)";
		Integer rs = jdbcTemplate.update(sql,mycase.getType(), mycase.getTitle(),
				mycase.getEditor(),mycase.getOrigin(),mycase.getDate(),
				mycase.getClick(),mycase.getContent());
		return rs;
	}

	@Override
	@Transactional
	public Case selectById(Integer id) {
		String sql = "select * from t_case where id=?";
		RowMapper<Case> rowMapper = new BeanPropertyRowMapper<>(Case.class);
		Case mycase = jdbcTemplate.queryForObject(sql, rowMapper, id);
		return mycase;
	}

	@Override
	public List<Case> selectSome(Integer index, Integer end) {
		String sql = "select * from t_case limit ?,?";
		RowMapper<List<Case>> rowMapper = new RowMapper<List<Case>>() {

			@Override
			public List<Case> mapRow(ResultSet rs, int rowNum) throws SQLException {
				List<Case> list = new ArrayList<>();
				Case mycase = null;
				do{
					mycase = new Case();
					mycase.setId(rs.getInt(1));
					mycase.setType(rs.getString(2));
					mycase.setTitle(rs.getString(3));
					mycase.setEditor(rs.getInt(4));
					mycase.setOrigin(rs.getString(5));
					mycase.setDate(rs.getTimestamp(6));
					mycase.setClick(rs.getInt(7));
					mycase.setContent(rs.getString(8));
					list.add(mycase);
				}while(rs.next());
				return list;
			}
		};
		List<Case> cases = jdbcTemplate.queryForObject(sql, rowMapper, index,end);
		return cases;
	}

	@Override
	public Integer selectForCount() {
		String sql = "select count(id) from t_case";
		Integer rs = jdbcTemplate.queryForObject(sql, Integer.class);
		return rs;
	}

	@Override
	public Integer updateClickPlusOne(Integer id, Integer plusNum) {
		String sql = "update t_case set click=click+? where id=?";
		Integer rs = jdbcTemplate.update(sql,plusNum,id);
		return rs;
	}

	@Override
	public Integer deleteById(Integer id) {
		String sql = "delete from t_case where id=?";
		Integer rs = jdbcTemplate.update(sql,id);
		return rs;
	}

	@Override
	public Integer update(Case case1) {
		String sql = "update t_case set title=?,type=?,click=?,origin=?,content=? where id=?";
		Integer rs = jdbcTemplate.update(sql,case1.getTitle(),case1.getType(),case1.getClick(),case1.getOrigin(),case1.getContent(),case1.getId());
		return rs;
	}

	@Override
	public List<Case> selectAll() {
		String sql = "select * from t_case";
		RowMapper<List<Case>> rowMapper = new RowMapper<List<Case>>() {

			@Override
			public List<Case> mapRow(ResultSet rs, int rowNum) throws SQLException {
				List<Case> list = new ArrayList<>();
				Case mycase = null;
				do{
					mycase = new Case();
					mycase.setId(rs.getInt(1));
					mycase.setType(rs.getString(2));
					mycase.setTitle(rs.getString(3));
					mycase.setEditor(rs.getInt(4));
					mycase.setOrigin(rs.getString(5));
					mycase.setDate(rs.getTimestamp(6));
					mycase.setClick(rs.getInt(7));
					mycase.setContent(rs.getString(8));
					list.add(mycase);
				}while(rs.next());
				return list;
			}
		};
		List<Case> cases = jdbcTemplate.queryForObject(sql, rowMapper);
		return cases;
	}

	
}
