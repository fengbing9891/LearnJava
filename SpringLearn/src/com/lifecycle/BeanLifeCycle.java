package com.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;


/**
 * bean初始化 销毁 三种方式
 * @author WBF
 *
 */
public class BeanLifeCycle implements InitializingBean, DisposableBean{

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("bean afterPropertiesSet");
	}
	
	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("bean destroy");
	}
	
	public void start(){
		System.out.println("bean start");
	}
	
	public void stop(){
		System.out.println("bean stop");
	}

	public void defaultInit(){
		System.out.println("bean defaultInit");
	}
	
	public void defaultDestroy(){
		System.out.println("bean defaultDestroy");
	}
	
}
