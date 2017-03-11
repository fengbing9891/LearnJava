package com.learn.dynamicProxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {

	private Object target;	//目标对象	被代理的对象
	
	public MyInvocationHandler(Object target){
		this.target  = target;
	}
	
	//代理类主要负责为委托类预处理消息、过滤消息、把消息转发给委托类，以及事后处理消息等
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("校验权限");
		method.invoke(target, args);	//执行被代理target对象的方法
		System.out.println("日志记录");
		return null;
	}

}
