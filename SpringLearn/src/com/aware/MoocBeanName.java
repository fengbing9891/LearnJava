package com.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/** 实现aware接口获得相关资源
 * 
 * @author WBF
 *
 */
public class MoocBeanName implements BeanNameAware, ApplicationContextAware{

	private String beanName;
	
	@Override
	public void setBeanName(String name) {
		// TODO Auto-generated method stub
		this.beanName = name;
		System.out.println("MoocBeanName : " + name);
	}

	@Override
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("setApplicationContext : " + context.getBean(this.beanName).hashCode());
	}

	
}
