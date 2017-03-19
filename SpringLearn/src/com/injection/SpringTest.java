package com.injection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@RunWith(BlockJUnit4ClassRunner.class)
public class SpringTest{

	public static void main(String[] args) {
		
	}
	
	@Test
	public void beanTest(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:spring-beanScope.xml");
		BeanScope beanScope = (BeanScope) context.getBean("beanScope");
		beanScope.say();
		
		BeanScope beanScope2 = (BeanScope) context.getBean("beanScope");
		beanScope2.say();
	}
}
