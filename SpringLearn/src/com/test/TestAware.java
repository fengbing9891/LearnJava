package com.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestAware {
	
	@Test
	public void testApplicationContext(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-aware.xml");
		context.start();
		System.out.println("testApplicationContext : " + context.getBean("moocApplicationContext").hashCode());
		context.destroy();
	}
	
	@Test
	public void testBeanName(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-aware.xml");
		context.start();
		System.out.println("testBeanName : " + context.getBean("moocBeanName").hashCode());
		context.destroy();
	}

}
