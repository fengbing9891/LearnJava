package com.learn.dynamicProxy.cglib;

/**
 * 需要被代理的类，也就是父类，通过字节码技术创建这个类的子类，实现动态代理。
 * @author WBF
 *
 */
public class SayHello {

	public void say(){
		System.out.println("hello everyone");
	}
}
