package com.imooc.mvcdemo;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/hello")
public class HelloMvcController {

	@RequestMapping("/mvc")
	public String helloMvc(){
		return "home";
	}
	
	@RequestMapping("/demo")
	public String viewCourse(@RequestParam("courseId") Integer courseId, Model model){
		model.addAttribute(courseId);
		return "home";
	}
	
//	@PathVariable是用来获得请求url中的动态参数的
	@RequestMapping("/demo/{courseId}")
	public String viewCourse2(@PathVariable("courseId") Integer courseId, Model model){
		model.addAttribute(courseId);
		return "home";
	}
	
//	@ModelAttribute 绑定请求参数到命令对象：放在功能处理方法的入参上时，用于将多个请求参数绑定到一个命令对象，从而简化绑
//	定流程，而且自动暴露为模型数据用于视图页面展示时使用；
	@RequestMapping("/save")
	public String save(@ModelAttribute Course course){
		return "redirect:/demo" + course.getId();
	}
	
	@RequestMapping("/upload")
	public String doUploadFile(@RequestParam("file") MultipartFile file) throws IOException{
		
		if(!file.isEmpty()){
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File("C:\\aa\\",file.getOriginalFilename()));
		}
		
		return "success";
	}
	
	//@RequestBody 将HTTP请求正文转换为适合的HttpMessageConverter对象。
	//@ResponseBody 将内容或对象作为 HTTP 响应正文返回，并调用适合HttpMessageConverter的Adapter转换对象，写入输出流。比如异步获取json数据，加上@responsebody后，会直接返回json数据
	// 该注解用于将Controller的方法返回的对象，通过适当的HttpMessageConverter转换为指定格式后，写入到Response对象的body数据区。
	//使用时机： 返回的数据不是html标签的页面，而是其他某种格式的数据时（如json、xml等）使用
	//返回json格式的数据
	@RequestMapping(value="/{courseId}")
	public @ResponseBody Course getCourseInJson(@PathVariable Integer courseId){
		return new Course();
	}
	
	//返回json格式的数据
//	@RequestMapping(value="/jsonType/{courseId}")
//	public ResponseEntity<Course> getCourseInJson2(@PathVariable Integer courseId){
//		Course course = new Course();
//		return new ResponseEntity<Course>(course, HttpStatus.OK);
//	}
	
	
}
