package com.beanannotation.jsr;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Service;

/**
 * @AutoWired @Resource @Inject ������ͬ��
 * @Named�ܹ�ע���࣬��������Ա����   ���Ծ���ָ��bean������,ʹ���ض����ƽ�������ע�룬��@Component��Ч
 * @PostConstruct �൱�� xml�е�  init-method 
 * @PreDestroy �൱�� xml�е�  destory-method
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
	
	//�൱�� xml�е�method-init
	@PostConstruct
	public void init(){
		System.out.println("JsrService init");
	}
	
	//�൱�� xml�е�method-destroy
	@PreDestroy
	public void destroy(){
		System.out.println("JsrService destroy");
	}
	
}

