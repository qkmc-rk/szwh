package com.cnbtl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

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
public class FileController {
	
	
	/**
	 * 上传图片的处理方法
	 * @param img 上传的图片
	 * @return 上传的图片的路径(相对于项目根路径)
	 */
	@RequestMapping(value="/uploadimg",method=RequestMethod.POST)
	public String uploadImage(MultipartFile img) {
		//需要判空处理
		if(!img.isEmpty()) {
			
		}
		return null;
	}
}
