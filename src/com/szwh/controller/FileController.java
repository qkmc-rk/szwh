package com.szwh.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.szwh.service.CaseService;

/**
 *���Դ���file��controller
 *��Ҫ����:
 *1.�ϴ�ͼƬ
 *2.�ϴ�����(������Ƶ)
 * 
 * 
 * @author Mrruan
 *
 */
@Controller
@RequestMapping("/upload")
public class FileController {
	
	@Autowired
	CaseService caseService;
	
	/**
	 * �ϴ�ͼƬ�Ĵ�����
	 * @param img �ϴ���ͼƬ
	 * @return �ϴ���ͼƬ��·��(�������Ŀ��·��)
	 * @throws IOException 
	 */
	@RequestMapping(value="/uploadimg",method=RequestMethod.POST)
	@ResponseBody
	public String uploadImage(@RequestParam("img") MultipartFile img,HttpSession session) throws IOException {
		//��Ҫ�пմ���
		System.out.println("��ʼ�ϴ�ͼƬ");
		if(!img.isEmpty() || img.getSize() > 0) {
			System.out.println("�ҵ��ļ�");
			//��ͼƬ�浽uploadfile��ȥ
			String fileName = img.getOriginalFilename();
			System.out.println("�ļ���" + fileName);
			//����һ���ļ�
			String realPath = "/static/uploadfile";
			String imgPath = session.getServletContext().getRealPath(realPath);
			System.out.println("·��3:" + imgPath);
			File file = new File(imgPath,fileName);
			img.transferTo(file);
			System.out.println("�ϴ��ɹ�23");
			return "{\"errno\": 0,\"data\": [\"/static/uploadfile/"+ fileName +"\"]}";
		}else {
			return "{\"errno\": -1}";
		}
	}
	/**
	 * 
	 * @param img
	 * @param session
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@RequestMapping(value="/uploadcover",method=RequestMethod.POST)
	@ResponseBody
	public String uploadCover(@RequestParam("id")Integer id,@RequestParam("cover") MultipartFile cover,HttpSession session) throws IllegalStateException, IOException {
		//��Ҫ�пմ���
		System.out.println("��ʼ�ϴ�����ͼƬ");
		if(!cover.isEmpty() || cover.getSize() > 0) {
			System.out.println("�ҵ��ļ�");
			//��ͼƬ�浽uploadfile��ȥ
			String fileName = cover.getOriginalFilename();
			System.out.println("�ļ���" + fileName);
			//����һ���ļ�
			String realPath = "/static/uploadfile";
			String imgPath = session.getServletContext().getRealPath(realPath);
			System.out.println("·��3:" + imgPath);
			File file = new File(imgPath,fileName);
			cover.transferTo(file);
			System.out.println("�ϴ��ɹ�23");
			//�ϴ��ɹ��ʹ浽���ݿ�
			if(caseService.updateCover(id, fileName) > 0)
				return "{\"errno\": 0,\"data\":\""+ fileName +"\"}";
			else
				return "{\"errno\": -2}";
		}else {
			return "{\"errno\": -1}";
		}
	}
}
