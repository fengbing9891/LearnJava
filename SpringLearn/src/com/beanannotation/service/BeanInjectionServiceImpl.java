package com.beanannotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import com.beanannotation.dao.BeanInjectionDao;

/**
 * ��ע���Զ�װ�� @Autowired
 * �ɱ�עset�������������������Լ���Ҫ�Զ�װ��Bean���õ����ⷽ��
 * @author WBF
 *
 */
@Service
public class BeanInjectionServiceImpl implements BeanInjectionService{

	@Autowired
	private BeanInjectionDao beanInjectionDao;
	
	//��ֵע��
//	@Autowired
//	@Required
//	public void setBeanInjectionDao(BeanInjectionDao beanInjectionDao) {
//		this.beanInjectionDao = beanInjectionDao;
//	}

	//������ע��
//	@Autowired
//	public BeanInjectionServiceImpl(BeanInjectionDao beanInjectionDao){
//		this.beanInjectionDao = beanInjectionDao;
//	}
	
	@Override
	public void save(String param) {
		// TODO Auto-generated method stub
		System.out.println("service ���������Ϊ��" + param);
		param = param + ":" +param.hashCode();
		beanInjectionDao.save(param);
	}


}
