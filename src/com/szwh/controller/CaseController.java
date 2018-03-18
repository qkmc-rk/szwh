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
 * case controller ����������ص�����
 * 1.����ҳ�Ż�ȡĳһҳ�����ݺ����ҳ��Ϣ(��һҳ��һҳ,��ǰҳ)
 * 2.���ĳ�����е���ϸ��Ϣ
 * ��̨:
 * 3.����Ա�޸�ĳ������
 * 4.����Ա����һ������
 * 5.����Աɾ��ĳ������
 * 6.����Ա�鿴�����б�
 * 7.����Ա�鿴ĳ����ϸ�İ���
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
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd�� HHʱmm��ss��");
		List<TitleAndDate> rs = new ArrayList<>();
		TitleAndDate titleAndDate;
		//��ȡ����case.
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
		//����json,����...
		String rsString = JSON.toJSONString(rs);
		System.out.println("JSON-->" + rsString);
		return rsString;
	}
	
	/**
	 * ����һ������
	 * @param type ��������
	 * @param title ���б���
	 * @param editor �༭�ߵ�id
	 * @param origin ��Դ
	 * @param content ���е���Ҫ����
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
		//Ĭ�Ϸ���
		if(cover == null || cover.equals(""))
			cover = "f.png";
		Case case1 = new Case();
		//��ֵ
		case1.setClick(1);
		case1.setDate(new Timestamp(new Date().getTime()));
		case1.setContent(content);
		case1.setEditor(editor);
		case1.setOrigin(origin);
		case1.setTitle(title);
		case1.setType(type);
		case1.setCover(cover);
		//�������
		System.out.println(case1);
		if(caseService.saveOneCase(case1))
			return JsonResult.RS_TRUE;
		return JsonResult.RS_FALSE;
	}
	
	/**
	 * ɾ��һ������
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
	 * �޸�һ������
	 * @param type ����
	 * @param title ����
	 * @param editor �༭��id
	 * @param origin ��Դ
	 * @param content ��Ҫ����
	 * @return �Ƿ��޸ĳɹ�
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
		
		//׼��һ������
		if(title == null || title.equals("") 
				|| content == null || content.equals("")
				|| click == null || id == null) {
			return JsonResult.RS_FALSE;
		}
		//Ĭ�Ϸ���
		if(cover == null || cover.equals(""))
			cover = "f.png";
		Case case1 = new Case();
		//��ֵ
		
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
	 * ���ҵ����е�һ������������
	 * @param id ���е�id��
	 * @return D����һ�����е�json��Ϣ
	 */
	@RequestMapping(value="/get/{id}",method=RequestMethod.GET)
	@ResponseBody
	public String getOneCase(@PathVariable("id")Integer id) {
		Case case1 = caseService.selectOneCaseById(id);
		String jsonResult = JSON.toJSONString(case1);
		return jsonResult;
	}
}





