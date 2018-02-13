package com.cnbtl.dao;

import java.util.List;

import com.cnbtl.entity.Case;

public interface CaseDao {
	
	/**
	 * 插入一个新的case(案例)
	 * @param mycase 我的案例
	 * @return 是否插入成功,返回1表示成功,返回0表示失败
	 */
	Integer insert(Case mycase);
	
	/**
	 * 查找到某一个具体的case
	 * @param id case的id
	 * @return 返回一个case案例.
	 */
	Case selectById(Integer id);
	
	/**
	 *  返回一组案例.
	 * @param index 案列开始的索引值
	 * @param end 案例结束的索引值
	 * @return 一组案列的列表形式
	 */
	List<Case> selectSome(Integer index,Integer end);
	
	/**
	 * 查找总记录条数
	 * @return 记录条数
	 */
	Integer selectForCount();
	
	
	List<Case> selectAll();
	
	/**
	 * 更新表中某一列的值+一个整数
	 * @param colName 列名
	 * @param plusNum  要增加的值
	 * @return 成功更新的条数.
	 */
	Integer updateClickPlusOne(Integer id,Integer plusNum);
	
	/**
	 * 删除一个案列,通过id来查询该案例
	 * @param id
	 * @return
	 */
	Integer deleteById(Integer id);
	
	/**
	 * 更新一个案例
	 * @param case1 要更新的内容
	 * @return 更新的记录条数
	 */
	Integer update(Case case1);
}
