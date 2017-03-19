package com.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aop.schema.advice.AspectBiz;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestAOPSchemaAdvice {

	@Test
	public void testBeforeAdvice(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:spring-aop-schema-advice.xml");
		context.start();
		
		AspectBiz aspectBiz = (AspectBiz) context.getBean("aspectBiz");
		aspectBiz.biz();
		
		context.destroy();
	}
	
	@Test
	public void testInit(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:spring-aop-schema-advice.xml");
		context.start();
		
		AspectBiz aspectBiz = (AspectBiz) context.getBean("aspectBiz");
		aspectBiz.init("moocService", 3);
		
		context.destroy();
	}
}
