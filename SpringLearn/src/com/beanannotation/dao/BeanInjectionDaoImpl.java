package com.beanannotation.dao;

import org.springframework.stereotype.Repository;

@Repository
public class BeanInjectionDaoImpl implements BeanInjectionDao{

	@Override
	public void save(String param) {
		// ģ�����ݿⱣ�����
		System.out.println("dao ���������Ϊ:" + param);
	}

}
