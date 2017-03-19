package com.beanannotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import com.beanannotation.dao.BeanInjectionDao;

/**
 * 用注解自动装配 @Autowired
 * 可标注set方法，构造器，属性以及需要自动装配Bean引用的任意方法
 * @author WBF
 *
 */
@Service
public class BeanInjectionServiceImpl implements BeanInjectionService{

	@Autowired
	private BeanInjectionDao beanInjectionDao;
	
	//设值注入
//	@Autowired
//	@Required
//	public void setBeanInjectionDao(BeanInjectionDao beanInjectionDao) {
//		this.beanInjectionDao = beanInjectionDao;
//	}

	//构造器注入
//	@Autowired
//	public BeanInjectionServiceImpl(BeanInjectionDao beanInjectionDao){
//		this.beanInjectionDao = beanInjectionDao;
//	}
	
	@Override
	public void save(String param) {
		// TODO Auto-generated method stub
		System.out.println("service 层接受数据为：" + param);
		param = param + ":" +param.hashCode();
		beanInjectionDao.save(param);
	}


}
