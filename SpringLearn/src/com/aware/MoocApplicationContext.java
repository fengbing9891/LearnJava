package com.aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/** 实现aware接口获得相关资源
 * 
 * @author WBF
 *
 */
public class MoocApplicationContext implements ApplicationContextAware{

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		System.out.println("MoocApplicationContext : "+ applicationContext.getBean("moocApplicationContext").hashCode());
	}

}
