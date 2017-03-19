package com.beanannotation.dao;

import org.springframework.stereotype.Repository;

@Repository
public class BeanInjectionDaoImpl implements BeanInjectionDao{

	@Override
	public void save(String param) {
		// 模拟数据库保存操作
		System.out.println("dao 层接受数据为:" + param);
	}

}
