package com.beanannotation.javabased;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

/**
 * @Bean注解学习，一般和@Configuration配合使用，此类完成的功能是在java中声明bean，相当于xml中的<bean id="" class=""/>
 * @author WBF
 *
 */
//@import 和 @importResource 都是导入另外一个配置，然后另外的配置里定义的bean就可以在现在配置类使用了
//@Import注解支持导入类
@Configuration	//相当于xml中的<beans>元素
@ImportResource("classpath:config.xml")		//类似于xml配置时的<import resource="cons-injecxml" />引入基于XML方式的配置文件
public class StoreConifg {

	@Value("${jdbc.url}")
	private String url;
	
	//config.properties文件中jdbc.username名称如果为username,则此处取出的值为操作系统登录名
	@Value("${jdbc.username}")
	private String username;
	
	@Value("${jdbc.password}")
	private String password;
	
	//定义bean 相当于xml中的<bean>元素，返回对象即为bean，方法名为该Bean的ID
	@Bean
	public MyDriverManager myDriverManager(){
		return new MyDriverManager(url, username, password);
	}
	
	
	
	//initMethod = "init", destroyMethod = "destroy" 相当于XML中的init-method,destroy-method
//	@Bean(name = "stringStore", initMethod = "init", destroyMethod = "destroy")
//	public Store stringStore(){
//		return new StringStore();
//	}
	
	//@Bean默认是单例的 proxyMode 代理方式
//	@Bean
//	@Scope(value ="prototype", proxyMode=ScopedProxyMode.TARGET_CLASS)
//	public Store stringStore(){
//		return new StringStore();
//	}
	
	@Autowired
	private Store<String> s1;
	
	@Autowired
	private Store<Integer> s2;
	
	@Bean
	public StringStore stringStore(){
		return new StringStore();
	}
	
	@Bean
	public IntegerStore integerStore(){
		return new IntegerStore();
	}
	
	@Bean
	public Store stringStoreTest(){
		System.out.println("s1 : " + s1.getClass().getName()); 
		System.out.println("s2 : " + s2.getClass().getName()); 
		return new StringStore();
	}
	
}
