package com.learn;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {

	public static void main(String[] args) {
		
		try {
			//1.通过字节码对象创建实例对象
			//User类还没有加载，在源文件阶段就获取其字节码文件对象
			Class class1 = Class.forName("com.learn.User");
			//创建user实例，这里是通过User的无参构造函数来创建的对象。
			User user = (User) class1.newInstance();
			
			//2.获取指定构造方法。constructor如果没有无参构造，只有有参构造如何创建实例：
			//获取字节码文件
//			Class class2 = Class.forName("com.learn.User");
			//先获取有参构造器，parameterTypes:表示参数列表，有多少写多少，也可以不写，不写就是调用无参构造器。
			Constructor constructor = class1.getConstructor(int.class, String.class);
			//通过构造器来实例化对象，将实际的参数传进去
			User user2 = (User) constructor.newInstance(12, "小明");
			
			//获取所有构造方法
			Constructor[] constructors = class1.getConstructors();
			for (int i = 0; i < constructors.length; i++) {
				//获取每个构造函数中的参数类型字节码对象
				Class[] parameterTypes = constructors[i].getParameterTypes();
				System.out.println("获取第" + i + "个构造函数");
				for (int j = 0; j < parameterTypes.length; j++) {
					//获取构造函数中的参数类型
					System.out.println(parameterTypes[i].getName() + ",");
				}
			}
			
			//3.获取成员变量并使用 Field对象
			//获取成员变量: class1.getField(name); 通过name来获取指定成员变量
			//如果该成员变量为私有的，则应该使用getDeclaredField(name)
			Field field = class1.getDeclaredField("id");
			//因为属性是私有的，获得其属性对象后，还要让其打开可见权限
			field.setAccessible(true);
			//对其成员变量进行操作，赋值操作	
			field.setInt(user, 5);	//通过set(obj, "李四")方法可以设置指定对象上该字段的值
			//获取成员变量的值，field.get(obj)； obj为所便是字段的值得对象，也就是该属性对应类的实例对象
			System.out.println(field.getInt(user));		//get(obj)可以获取指定对象中该字段的值
			
			//获取全部成员变量
			Field[] fields = class1.getDeclaredFields();	//将私有的属性也一并获得
			for (int i = 0; i < fields.length; i++) {
				fields[i].setAccessible(true); //将权限打开
				System.out.println(fields[i].get(user));	//获取成员变量的值
			}
			
			
			//4.获得方法并使用	Method
			//不带参数的方法，learn为不带参数的public方法
			/**
			 * class1.getMethod(name, parameterTypes)
			 * name:方法的名字
			 * parameterTypes：方法的参数类型的Class类型，没有则什么都不填，比如参数为String，则填String.class
			 * 
			 */
			Method method = class1.getMethod("learn");
			//调用方法
			/**
			 * method.invoke(obj, args)
			 * obj:方法的对象
			 * args：实际的参数值，没有则不填
			 */
			method.invoke(user, null);
			
			//带参数的方法，sing为带一个String类型参数的方法
			Method method1 = class1.getMethod("sing", String.class);
			method1.invoke(user, "成都");
			
			//获取私有的方法，和获取私有的属性一样，say为私有方法
			Method method2 = class1.getDeclaredMethod("say");
			method2.setAccessible(true);
			method2.invoke(user);	//可以调用该方法
			
			//一次性获得所有的方法
			Method[] methods = class1.getDeclaredMethods();
			for (Method m : methods) {
				m.setAccessible(true);
				System.out.println(m.getName());
				//获得方法的参数
				Class<?>[] parameterTypes = m.getParameterTypes();
				for (int i = 0; i < parameterTypes.length; i++) {
					System.out.println(parameterTypes[i].getName()+",");
				}
			}
			
			//获得该类的所有接口	返回值：接口的字节码文件对象的数组
			Class[] interfaces = class1.getInterfaces();	//确定此对象所表示的类或接口实现的接口
		
			
		} catch (ClassNotFoundException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
