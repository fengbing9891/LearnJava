package com.learn;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


/**
 * 反射
 * @author WBF
 *
 */
public class Reflect {
	//在运行状态中，对于任意一个类，都能够获取到这个类的所有属性和方法，对于任何一个对象，都能够调用它的
	//任意一个方法和属性（包括私有的方法和属性），这种动态获取的信息或者动态调用对象的方法的功能就称为
	//java语言的反射机制。通俗点讲，通过反射，该类对我们是透明的，想要获取任何东西都可以。
	
	//想要使用反射机制，就必须获得字节码文件对象（.class），通过字节码文件对象，就能够通过该类中的方法
	//获取到我们想要的所有信息（方法，属性，类名，父类名，实现的所有接口等等），每一个类对应着一个字节码
	//文件也就对应着一个Class类型的对象，也就是字节码文件对象。
	
	public void learnReflect(){
		//获取字节码文件对象的三种方式
		
		//1.通过Class类中的静态方法forName,直接获取到一个类的字节码文件对象，此时该类还是源文件阶段，并没有变为字节码文件
		try {
			Class class1 = Class.forName("com.learn.Person");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	//加载参数指定的类，并且初始化它。
		
		//2.当类被加载成.class文件时，此时Person类变成了.class，在获取该字节码文件对象，也就是获取自己，该类处于字节码阶段
		Class class2 = Person.class;
		
		//3.通过类的实例获取该类的字节码文件对象，该类处于创建对象阶段
		Person p = new Person();
		Class class3 =  p.getClass();
	}

	//有了字节码文件对象才能获得类中的所有信息，我们在使用反射获取信息时，也要考虑使用上面哪种方式获取
	//字节码对象合理，视不同情况而定。
	
	
	public static void main(String[] args) {
		//通过反射，在泛型为int的arryaList集合中存放一个String类型的对象
		//原理：集合中泛型只在编译期有效，而到了运行期，泛型则会失效
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
//		list.add("aaa");	在编译期，泛型生效，插入字符串对象，则报错。
		try {
			Class class1 = list.getClass();	//获得其字节码文件对象
			Method method = class1.getMethod("add", Object.class);
			method.invoke(list, "aaa");
			System.out.println(list);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
}
