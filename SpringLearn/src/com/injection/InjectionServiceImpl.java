package com.injection;

public class InjectionServiceImpl implements InjectionService{

	public InjectionDao injectionDao;
	
	//��ֵע��
	public void setInjectionDao(InjectionDao injectionDao) {
		this.injectionDao = injectionDao;
	}

	//������ע��
	public InjectionServiceImpl(InjectionDao injectionDao){
		this.injectionDao = injectionDao;
	}
	
	
	@Override
	public void save(String param) {
		// TODO Auto-generated method stub
		System.out.println("service ���������Ϊ��" + param);
		param = param + ":" +param.hashCode();
		injectionDao.save(param);
	}

}
