package com.szwh.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.szwh.entity.Case;
import com.szwh.entity.extra.TitleAndDate;
import com.szwh.service.CaseService;
import com.szwh.util.JsonResult;

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
				titleAndDate.setClick(case1.getClick());
				titleAndDate.setOrigin(case1.getOrigin());
				titleAndDate.setType(case1.getType());
				rs.add(titleAndDate);
			}
		}
		//做成json,返回...
		String rsString = JSON.toJSONString(rs);
		System.out.println("JSON-->" + rsString);
		return rsString;
	}
	
	/**
	 * 增加一个案列
	 * @param type 案列类型
	 * @param title 案列标题
	 * @param editor 编辑者的id
	 * @param origin 来源
	 * @param content 案列的主要内容
	 * @return
	 */
	@RequestMapping(value="/add")
	@ResponseBody
	public String uploadCase(@RequestParam("type") String type,
			@RequestParam("title") String title,
			@RequestParam("editor") Integer editor,
			@RequestParam("origin") String origin,
			@RequestParam("content") String content,
			@RequestParam(value="cover",required=false) String cover){
		if(title == null || title.equals("") || editor == null || editor.equals("")
				|| origin == null || origin.equals("") || content == null || content.equals("")) {
			return JsonResult.RS_FALSE;
		}
		//默认封面
		if(cover == null || cover.equals(""))
			cover = "f.png";
		Case case1 = new Case();
		//赋值
		case1.setClick(1);
		case1.setDate(new Timestamp(new Date().getTime()));
		case1.setContent(content);
		case1.setEditor(editor);
		case1.setOrigin(origin);
		case1.setTitle(title);
		case1.setType(type);
		case1.setCover(cover);
		//保存操作
		System.out.println(case1);
		if(caseService.saveOneCase(case1))
			return JsonResult.RS_TRUE;
		return JsonResult.RS_FALSE;
	}
	
	/**
	 * 删除一个案列
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	public String deleteCase(@PathVariable("id")Integer id) {
		if(id == null) {
			return JsonResult.RS_FALSE;
		}
		boolean rs = caseService.deleteOneCaseById(id);
		if(rs)
			return JsonResult.RS_TRUE;
		return JsonResult.RS_FALSE;
	}
	
	/**
	 * 修改一个案列
	 * @param type 类型
	 * @param title 标题
	 * @param editor 编辑者id
	 * @param origin 来源
	 * @param content 主要内容
	 * @return 是否修改成功
	 */
	@RequestMapping(value="/update/{id}")
	@ResponseBody
	public String update(@PathVariable("id")Integer id,
			@RequestParam("type") String type,
			@RequestParam("title") String title,
			@RequestParam("origin") String origin,
			@RequestParam("content") String content,
			@RequestParam("click")Integer click,
			@RequestParam("cover")String cover) {
		
		//准备一个案列
		if(title == null || title.equals("") 
				|| content == null || content.equals("")
				|| click == null || id == null) {
			return JsonResult.RS_FALSE;
		}
		//默认封面
		if(cover == null || cover.equals(""))
			cover = "f.png";
		Case case1 = new Case();
		//赋值
		
		case1.setId(id);
		case1.setContent(content);
		case1.setTitle(title);
		case1.setType(type);
		case1.setClick(click);
		case1.setOrigin(origin);
		if(caseService.updateOneCase(case1))
			return JsonResult.RS_TRUE;
		return JsonResult.RS_FALSE;
	}
	
	/**
	 * 查找到其中的一个案例并返回
	 * @param id 案列的id号
	 * @return D返回一个案列的json信息
	 */
	@RequestMapping(value="/get/{id}",method=RequestMethod.GET)
	@ResponseBody
	public String getOneCase(@PathVariable("id")Integer id) {
		Case case1 = caseService.selectOneCaseById(id);
		String jsonResult = JSON.toJSONString(case1);
		return jsonResult;
	}
}





