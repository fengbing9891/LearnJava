package com.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.autowiring.AutoWiringService;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestAutoWiring {

	@Test
	public void testAutoWiring(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:spring-autowiring.xml");
		context.start();
		
		AutoWiringService autoWiringService = (AutoWiringService) context.getBean("autoWiringService");
		autoWiringService.say("This is a Taojinyang Test");
		
		context.destroy();
	}
}
