package com.beanannotation.jsr;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Service;

/**
 * @AutoWired @Resource @Inject 功能相同，
 * @Named能够注解类，方法，成员变量   可以具体指定bean的名称,使用特定名称进行依赖注入，与@Component等效
 * @PostConstruct 相当于 xml中的  init-method 
 * @PreDestroy 相当于 xml中的  destory-method
 * @author WBF
 *
 */
//@Service
@Named
public class JsrService {

//	@Resource
//	@Inject
	private JsrDao jsrDao;
	
//	@Resource
	@Inject
	public void setJsrDao(@Named("jsrDao") JsrDao jsrDao) {
		this.jsrDao = jsrDao;
	}

	public void save(){
		jsrDao.save();
	}
	
	//相当于 xml中的method-init
	@PostConstruct
	public void init(){
		System.out.println("JsrService init");
	}
	
	//相当于 xml中的method-destroy
	@PreDestroy
	public void destroy(){
		System.out.println("JsrService destroy");
	}
	
}

