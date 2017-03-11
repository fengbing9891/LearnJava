package com.learn.dynamicProxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {

	private Object target;	//Ŀ�����	������Ķ���
	
	public MyInvocationHandler(Object target){
		this.target  = target;
	}
	
	//��������Ҫ����Ϊί����Ԥ������Ϣ��������Ϣ������Ϣת����ί���࣬�Լ��º�����Ϣ��
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("У��Ȩ��");
		method.invoke(target, args);	//ִ�б�����target����ķ���
		System.out.println("��־��¼");
		return null;
	}

}
