package com.szwh.service;

import java.util.List;

import com.szwh.entity.Case;

public interface CaseService {

	/**
	 * 获取所有的案列
	 * @return 所有案列
	 */
	List<Case> getAllCase();
	
	
	/**
	 * 保存一个案列
	 * @param case1 案列对象
	 * @return 布尔值,是否增加案列成功
	 */
	boolean saveOneCase(Case case1);

	/**
	 * 删除一个案列,通过案列的id值
	 * @param id
	 */
	boolean deleteOneCaseById(Integer id);
	
	/**
	 * 更新一个案列
	 * @param case1  案列的修改后信息
	 * @return 是否修改成功
	 */
	boolean updateOneCase(Case case1);
	
	/**
	 * 查找一个案列,通过其id值来查找
	 * @param id id
	 * @return 一个案列(Case)的实例对象
	 */
	Case selectOneCaseById(Integer id);


	List<Case> selectSomeCase(int start, int end);
	
	Integer plusClick(Integer id, Integer plusNum);
	
}
