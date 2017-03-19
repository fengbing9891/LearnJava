package com.injection;

public class InjectionDaoImpl implements InjectionDao{

	@Override
	public void save(String param) {
		// TODO Auto-generated method stub
		System.out.println("dao 层接受数据为:" + param);
	}

}
