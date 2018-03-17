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
 *用以处理file的controller
 *主要功能:
 *1.上传图片
 *2.上传附件(多是视频)
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
	 * 上传图片的处理方法
	 * @param img 上传的图片
	 * @return 上传的图片的路径(相对于项目根路径)
	 * @throws IOException 
	 */
	@RequestMapping(value="/uploadimg",method=RequestMethod.POST)
	@ResponseBody
	public String uploadImage(@RequestParam("img") MultipartFile img,HttpSession session) throws IOException {
		//需要判空处理
		System.out.println("开始上传图片");
		if(!img.isEmpty() || img.getSize() > 0) {
			System.out.println("找到文件");
			//将图片存到uploadfile中去
			String fileName = img.getOriginalFilename();
			System.out.println("文件名" + fileName);
			//定义一个文件
			String realPath = "/static/uploadfile";
			String imgPath = session.getServletContext().getRealPath(realPath);
			System.out.println("路径3:" + imgPath);
			File file = new File(imgPath,fileName);
			img.transferTo(file);
			System.out.println("上传成功23");
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
		//需要判空处理
		System.out.println("开始上传封面图片");
		if(!cover.isEmpty() || cover.getSize() > 0) {
			System.out.println("找到文件");
			//将图片存到uploadfile中去
			String fileName = cover.getOriginalFilename();
			System.out.println("文件名" + fileName);
			//定义一个文件
			String realPath = "/static/uploadfile";
			String imgPath = session.getServletContext().getRealPath(realPath);
			System.out.println("路径3:" + imgPath);
			File file = new File(imgPath,fileName);
			cover.transferTo(file);
			System.out.println("上传成功23");
			//上传成功就存到数据库
			if(caseService.updateCover(id, fileName) > 0)
				return "{\"errno\": 0,\"data\":\""+ fileName +"\"}";
			else
				return "{\"errno\": -2}";
		}else {
			return "{\"errno\": -1}";
		}
	}
}
