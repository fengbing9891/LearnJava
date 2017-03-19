package com.test;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.resource.MoocResource;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestResource {

	@Test
	public void testReource(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-resource.xml");
		context.start();
		
		MoocResource moocResource = (MoocResource) context.getBean("moocResource");
		try {
			moocResource.resource();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		context.destroy();
	}
}
