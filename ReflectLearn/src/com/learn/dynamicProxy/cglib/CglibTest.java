package com.learn.dynamicProxy.cglib;

public class CglibTest {

	//使用CGLib实现动态代理，CGLib使用了非常底层的字节码技术，其原理是通过字节码技术为一个类创建子类，
	//并在子类中采用方法拦截的技术拦截所有父类方法的调用，顺势织入横切逻辑。JDK动态代理和CGLib动态代理
	//均是实现Spring AOP的基础
	
	//CGLib创建的动态代理对象性能比JDK创建的动态代理对象的性能高不少，但是CGLib在创建代理对象时所花费的时间却比JDK多得多，
	//所以对于单例的对象，因为无需频繁创建对象，用CGLib合适，反之，使用JDK方式要更为合适一些。同时，由于CGLib由于是采用动态创建子类的方法，
	//对于final方法，无法进行代理。
	public static void main(String[] args) {
		CglibProxy cglib = new CglibProxy();
		//通过生成子类的方式创建代理类
		SayHello s = (SayHello) cglib.getProxy(new SayHello());
		s.say();
	}
}
