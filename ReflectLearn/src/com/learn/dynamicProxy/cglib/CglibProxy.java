package com.learn.dynamicProxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * ����ʵ���˴�������ķ��������ķ�����getProxy(SuperClass����)����ͨ����μ�����Ķ���ͨ����չ�����class�������������
 * 
 * @author WBF
 *
 */
public class CglibProxy implements MethodInterceptor {

	private Object target;
	
	public Object getProxy(Object target){
		this.target = target;
		
		//��ǿ��
		Enhancer enhancer = new Enhancer();
		//��ֵ��Ҫ�����������
		enhancer.setSuperclass(this.target.getClass());
		//�ص�����
		enhancer.setCallback(this);
		//ͨ���ֽ��뼼����̬��������ʵ�����������
		return enhancer.create();
	}
	
	/**
	 * intercept()������������Ŀ�귽���ĵ��ã�obj��ʾĿ�����ʵ����methodΪĿ���෽����argsΪ������
	 * ��̬��Σ�proxyΪ������ʵ����proxy.invokeSuper(obj, args)ͨ����������ø����еķ�����
	 */
	@Override
	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		System.out.println("ǰ�ô���");
		proxy.invokeSuper(obj, args);
		System.out.println("���ô���");
		return null;
	}

}
