package com.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestBeanLifeCycle {

	@Test
	public void test1(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:spring-lifeCycle.xml");
		context.start();
		context.getBean("beanLifeCycle");
		context.destroy();
	}
}
