package com.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beanannotation.BeanAnnotation;
import com.beanannotation.javabased.MyDriverManager;
import com.beanannotation.multibean.BeanInvoker;
import com.beanannotation.service.BeanInjectionServiceImpl;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestBeanAnnotation {

	@Test
	public void testBeanAnnotation(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-beanannotation.xml");
		context.start();
		
		
		BeanAnnotation beanAnnotation = (BeanAnnotation) context.getBean("beanAnnotation");
		beanAnnotation.say("This is a Taojinyang Test");
		
		beanAnnotation = (BeanAnnotation) context.getBean("bean");
		beanAnnotation.say("This is a Taojinyang Test");
		
		context.destroy();
	}
	
	@Test
	public void testScope(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-beanannotation.xml");
		context.start();
		
		BeanAnnotation beanAnnotation = (BeanAnnotation) context.getBean("beanAnnotation");
		beanAnnotation.myHashCode();
		
		beanAnnotation = (BeanAnnotation) context.getBean("beanAnnotation");
		beanAnnotation.myHashCode();
		
		context.destroy();
	}
	
	@Test
	public void testAutowired(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-beanannotation.xml");
		context.start();
		
		BeanInjectionServiceImpl beanInjectionServiceImpl = (BeanInjectionServiceImpl) context.getBean("beanInjectionServiceImpl");
		beanInjectionServiceImpl.save("This is Taojingyang Autowired Test");
		
		context.destroy();
		
	}
	
	//≤‚ ‘autowired
	@Test
	public void testMultiBean(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-beanannotation.xml");
		context.start();
		
		BeanInvoker beanInvoker = (BeanInvoker) context.getBean("beanInvoker");
		beanInvoker.say();
		
		context.destroy();
	}
	
}




