package com.learn.dynamicProxy.jdk;

import java.lang.reflect.Proxy;

public class DynamicProxy {

	//动态代理：一种设计模式，其非常简单，很容易理解：你可以自己做这件事，但是觉得自己做非常麻烦或者不方便，所以就叫另一个人（代理）
	//来帮你做这个事情，而你就不用管了，这就是动态代理。举个例子：买火车票叫人代买。
	//在程序运行过程中产生的这个对象，而程序运行过程中产生对象其实就是反射讲解的内容，所以，动态代理其实就是通过反射来生成一个代理
	//在java中java.lang.reflect包下提供了一个Proxy类和一个InvocationHandler接口，通过使用这个类和接口就可以生成动态代理对象。JDK
	//提供的代理只能针对接口做代理。我们有更强大的cglib，Proxy类中的方法创建动态代理类对象。
	
	//分三步，但是注意JDK提供的代理只能针对接口做代理，也就是下面的第二步返回的必须要是一个接口。
	
	//1.new出代理对象。通过实现InvacationHandler接口，然后new出代理对象来。
	//2.通过Proxy类中的静态方法newProxyInstanse，来将代理对象假装成那个被代理的对象，也就是如果叫人帮我们代买火车票一样，那个代理
	//就假装成我们自己本人
	//3.执行方法，代理成功。
	
	public static void main(String[] args) {
		StudentImpl si = new StudentImpl();	//被代理对象
		MyInvocationHandler m = new MyInvocationHandler(si);	//new出代理对象
		//newProxyInstance的三个参数，第一个：类加载器，第二个：被代理对象的接口，	第三个：代理对象
		Student s = (Student) Proxy.newProxyInstance(si.getClass().getClassLoader(), si.getClass().getInterfaces(), m);	//将代理对象假装成那个被代理的对象
		s.login();
		s.submit();
	}
	
}
