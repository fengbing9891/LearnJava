package com.resource;

import java.io.IOException;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;

public class MoocResource implements ApplicationContextAware{

	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}

	public void resource() throws IOException{
		//���ַ�ʽ�����Դ
//		Resource resource = this.applicationContext.getResource("classpath:config.txt");
//		Resource resource = this.applicationContext.getResource("file:E:\\work\\workspace\\SpringLearn\\src\\config.txt");
//		Resource resource = this.applicationContext.getResource("url:http://maven.apache.org/settings.html");
		//û��ǰ׺������applicationContext�ķ�ʽ��Ϊ·��ǰ׺
		Resource resource = this.applicationContext.getResource("config.txt");
		System.out.println(resource.getFilename());
		System.out.println(resource.contentLength());
	}
}
