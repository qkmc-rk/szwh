package com.szwh.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.szwh.entity.Case;
import com.szwh.service.CasePageService;
import com.szwh.service.CaseService;
import com.szwh.util.Page;

/**
 * ����ǰ��ҳ���һЩ�����ת��
 * ��Ϊ��Ҫ��һЩmodel�İ�,�����Ҫʹ��controller������.
 * @author Mrruan
 *
 */

@Controller
public class FrontendController {

	@Autowired
	CaseService caseService;
	
	@Autowired
	CasePageService casePageService;
	
	/**
	 * ������ҳ
	 * ��ҳ��Ҫ����������
	 * model 6������
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView index(Integer start, Integer end) {
		ModelAndView mdv = new ModelAndView();
		//1.��ȡ6������
		if(start == null || end == null) {
			start = 0;
			end = 6;
		}
		List<Case> cases;
		try {
			cases = caseService.getAllCase();
			if(cases != null) {
				cases = cases.subList(start, end);
				mdv.addObject("cases", cases);
				mdv.setViewName("/frontend/index");
			}else {
				mdv.addObject("message","��ҳ��ȡ����ʱ������������!����Ϊ" + start + "-" + end);
				mdv.setViewName("/error");
			}
		} catch (Exception e) {
			e.printStackTrace();
			mdv.addObject("message","��ҳ��ȡ����ʱ������������!����Ϊ" + start + "-" + end);
			mdv.setViewName("/error");
		}
		//2.������ҳ
		return mdv;
	}
	
	/**
	 * ���ط���ҳ��,��̬ҳ��
	 * @return ��̬������ͼ��·��������
	 */
	@RequestMapping("/service")
	public String service() {
		return "/frontend/service";
	}
	
	/**
	 * ���ذ���ҳ��,��ҳ������ܶస��,��Ҫ
	 * ���page��ҳʳ��
	 * @return ����ҳ��
	 */
	@RequestMapping("/article")
	public ModelAndView article(@RequestParam(value="type",required=false)String type,
			Integer currentPage) {
		
		ModelAndView mdv = new ModelAndView();
		if(currentPage == null) currentPage = 1;
		/**
		 * �˴�û�ж�type���д���
		 * ��Ϊ��ʱû����δ��������,�Ⱥ��ڵ�������.
		 */
		//��ȡ��ҳ��Page
		Page<Case> page = casePageService.getPage(currentPage);
		if(page != null) {
			
			/*//1.����type���й���һ��
			List<Case> list = page.getList();
			Iterator<Case> i = list.iterator();
			if(type != null) {
				switch(type) {
				
				case "brand":{
					while(i.hasNext()) {
						Case c = (Case) i.next();
						if(!c.getType().equals("brand")) {
							i.remove();
						}
					}
				}
				break;
				case "activity":{
					while(i.hasNext()) {
						Case c = (Case) i.next();
						if(!c.getType().equals("activity")) {
							i.remove();
						}
					}
				}
				break;
				case "design":{
					while(i.hasNext()) {
						Case c = (Case) i.next();
						if(!c.getType().equals("design")) {
							i.remove();
						}
					}
				}
				break;
				case "movie":{
					while(i.hasNext()) {
						Case c = (Case) i.next();
						if(!c.getType().equals("movie")) {
							i.remove();
						}
					}
				}
				break;
				}
			}
			//1.5ɾ������������һ���ڷ���
			page.setList(list);*/
			//2.����
			mdv.addObject("page", page);
			System.out.println(page.getList());
			mdv.setViewName("/frontend/article");
		}else {
			mdv.addObject("message","û�л�ȡ����ҳ���ڵ��б���Ϣ all");
			mdv.setViewName("/error");
		}
		//��pageװ��model,����
		return mdv;
	}
	
	@RequestMapping("/article_activity")
	public ModelAndView article_activity(@RequestParam(value="type",required=false)String type,
			Integer currentPage) {
		
		ModelAndView mdv = new ModelAndView();
		if(currentPage == null) currentPage = 1;
		type = "activity";
		//��ȡ��ҳ��Page
		Page<Case> page = casePageService.getPageByType(currentPage, type);
		if(page != null) {
			mdv.addObject("page", page);
			System.out.println(page.getList());
			mdv.setViewName("/frontend/article_activity");
		}else {
			mdv.addObject("message","û�л�ȡ����ҳ���ڵ��б���Ϣ activity");
			mdv.setViewName("/error");
		}
		//��pageװ��model,����
		return mdv;
	}
	@RequestMapping("/article_design")
	public ModelAndView article_design(@RequestParam(value="type",required=false)String type,
			Integer currentPage) {
		
		ModelAndView mdv = new ModelAndView();
		if(currentPage == null) currentPage = 1;
		type = "design";
		//��ȡ��ҳ��Page
		Page<Case> page = casePageService.getPageByType(currentPage, type);
		if(page != null) {
			mdv.addObject("page", page);
			System.out.println(page.getList());
			mdv.setViewName("/frontend/article_design");
		}else {
			mdv.addObject("message","û�л�ȡ����ҳ���ڵ��б���Ϣ design");
			mdv.setViewName("/error");
		}
		//��pageװ��model,����
		return mdv;
	}
	
	@RequestMapping("/article_movie")
	public ModelAndView article_movie(@RequestParam(value="type",required=false)String type,
			Integer currentPage) {
		
		ModelAndView mdv = new ModelAndView();
		if(currentPage == null) currentPage = 1;
		type = "movie";
		//��ȡ��ҳ��Page
		Page<Case> page = casePageService.getPageByType(currentPage, type);
		if(page != null) {
			mdv.addObject("page", page);
			System.out.println(page.getList());
			mdv.setViewName("/frontend/article_movie");
		}else {
			mdv.addObject("message","û�л�ȡ����ҳ���ڵ��б���Ϣ movie");
			mdv.setViewName("/error");
		}
		//��pageװ��model,����
		return mdv;
	}
	
	
	@RequestMapping("/article_show")
	public ModelAndView article_show(@RequestParam(value="id",required=false) Integer id) {
		ModelAndView mdv = new ModelAndView();
		//1.ͨ��id��ѯ������
		List<Case> cases = caseService.getAllCase();
		if(id == null) {
			id = cases.get(0).getId();
		}
		Case case0,case1 = null,case2;
		//��list�л�ȡָ��id�ļ�¼.
		for (Case cs : cases) {
			if(cs.getId() == id) {
				case1 = cs;
				break;
			}
		}
		//��list�л�ȡָ��id��object��ǰһ��.��Ҫ�ж��Ƿ��ǵ�һ��
		if(cases.indexOf(case1)-1 >= 0 && null != cases.get(cases.indexOf(case1) - 1) ) {
			case0 = cases.get(cases.indexOf(case1)-1);
		}else {
			case0 = null;
		}
		//��list�л�ȡָ��id��object�ĺ�һ��,��Ҫ�ж��Ƿ������һ��
		if(cases.indexOf(case1)+1 < cases.size() && null != cases.get(cases.indexOf(case1) + 1) ) {
			case2 = cases.get(cases.indexOf(case1)+1);
		}else {
			case2 = null;
		}
		//������ͼ
		if(case1 != null) {
			mdv.addObject("case0", case0);
			mdv.addObject("case1", case1);
			mdv.addObject("case2", case2);
			mdv.setViewName("/frontend/article_show");
			//���ʴ�����������������ʵ��.
			//...
		}else {
			mdv.addObject("message", "��ȡָ��Id=" + id +"�İ���ʱ���ִ���!");
			mdv.setViewName("/error");
		}
		//2.������ͼ
		return mdv;
	}
	
	/**
	 * ������ϵҳ��
	 * @return ��ϵ��ͼ��·��������
	 */
	@RequestMapping("/contact")
	public String contact() {
		return "/frontend/contact";
	}
	/**
	 * ���ع���ҳ��
	 * @return ������ͼ��·��������
	 */
	@RequestMapping("/about")
	public String about() {
		return "/frontend/about";
	}
	
	@RequestMapping("/article_custom")
	public String article_custom() {
		return "/frontend/article_custom";
	}
	
}
