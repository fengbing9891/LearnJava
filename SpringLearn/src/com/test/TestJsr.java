package com.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beanannotation.jsr.JsrService;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestJsr {
	
	@Test
	public void testJsr(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-beanannotation.xml");
		context.start();
	
		JsrService jsrService = (JsrService) context.getBean("jsrService");
		jsrService.save();
		
		context.destroy();
	}

}
