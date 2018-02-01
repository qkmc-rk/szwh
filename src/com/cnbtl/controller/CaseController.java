package com.cnbtl.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.cnbtl.entity.Case;
import com.cnbtl.entity.extra.TitleAndDate;
import com.cnbtl.service.CaseService;

/**
 * case controller 负责处理案列相关的请求
 * 1.根据页号获取某一页的内容和相关页信息(上一页下一页,当前页)
 * 2.获得某个案列的详细信息
 * 后台:
 * 3.管理员修改某个案列
 * 4.管理员增加一个案列
 * 5.管理员删除某个案列
 * 6.管理员查看案列列表
 * 7.管理员查看某个详细的案列
 * 
 * @author Mrruan
 *
 */
@Controller
@RequestMapping(value="/case")
public class CaseController {

	@Autowired
	CaseService caseService;
	
	/**
	 * 
	 */
	@RequestMapping("/allftd")
	@ResponseBody
	public String getAllcase() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
		List<TitleAndDate> rs = new ArrayList<>();
		TitleAndDate titleAndDate;
		//获取所有case.
		List<Case> cases = caseService.getAllCase();
		if(cases != null) {
			for (Case case1 : cases) {
				titleAndDate = new TitleAndDate();
				titleAndDate.setTitle(case1.getTitle());
				titleAndDate.setDate(sdf.format(new Date(case1.getDate().getTime())));
				titleAndDate.setId(case1.getId());
				rs.add(titleAndDate);
			}
		}
		//做成json,返回...
		String rsString = JSON.toJSONString(rs);
		System.out.println("JSON-->" + rsString);
		return rsString;
	}
}
