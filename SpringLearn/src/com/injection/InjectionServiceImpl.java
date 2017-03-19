package com.injection;

public class InjectionServiceImpl implements InjectionService{

	public InjectionDao injectionDao;
	
	//设值注入
	public void setInjectionDao(InjectionDao injectionDao) {
		this.injectionDao = injectionDao;
	}

	//构造器注入
	public InjectionServiceImpl(InjectionDao injectionDao){
		this.injectionDao = injectionDao;
	}
	
	
	@Override
	public void save(String param) {
		// TODO Auto-generated method stub
		System.out.println("service 层接受数据为：" + param);
		param = param + ":" +param.hashCode();
		injectionDao.save(param);
	}

}
