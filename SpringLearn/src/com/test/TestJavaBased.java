package com.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beanannotation.BeanAnnotation;
import com.beanannotation.javabased.MyDriverManager;
import com.beanannotation.javabased.Store;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestJavaBased {

	@Test
	public void testJavaBased(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-beanannotation.xml");
		context.start();
		
		Store store = (Store) context.getBean("stringStore");
		System.out.println(store.getClass().getName());
		
		context.destroy();
	}
	
	@Test
	public void testMyDriverManager(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-beanannotation.xml");
		context.start();
		
		MyDriverManager myDriverManager = (MyDriverManager) context.getBean("myDriverManager");
		System.out.println(myDriverManager.getClass().getName());
		
		context.destroy();
	}
	
	@Test
	public void testScope(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-beanannotation.xml");
		context.start();
		
		Store store = (Store) context.getBean("stringStore");
		System.out.println(store.hashCode());
		
		store = (Store) context.getBean("stringStore");
		System.out.println(store.hashCode());
		
		context.destroy();
	}
	
	@Test
	public void testG(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-beanannotation.xml");
		context.start();
		
		Store store = (Store) context.getBean("stringStoreTest");
		
		context.destroy();
	}
	
}
