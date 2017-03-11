package com.learn.dynamicProxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 该类实现了创建子类的方法与代理的方法。getProxy(SuperClass对象)方法通过入参即父类的对象，通过扩展父类的class来创建代理对象。
 * 
 * @author WBF
 *
 */
public class CglibProxy implements MethodInterceptor {

	private Object target;
	
	public Object getProxy(Object target){
		this.target = target;
		
		//增强器
		Enhancer enhancer = new Enhancer();
		//设值需要创建子类的类
		enhancer.setSuperclass(this.target.getClass());
		//回调方法
		enhancer.setCallback(this);
		//通过字节码技术动态创建子类实例（代理对象）
		return enhancer.create();
	}
	
	/**
	 * intercept()方法拦截所有目标方法的调用，obj表示目标类的实例，method为目标类方法，args为方法的
	 * 动态入参，proxy为代理类实例。proxy.invokeSuper(obj, args)通过代理类调用父类中的方法。
	 */
	@Override
	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		System.out.println("前置代理");
		proxy.invokeSuper(obj, args);
		System.out.println("后置代理");
		return null;
	}

}
