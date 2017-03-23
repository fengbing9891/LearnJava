package com.ann.test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import define.DefineAnn;

public class ParseAnn {

	public static void main(String[] args) {
		try {
			//使用类加载器加载类
			Class c = Class.forName("com.ann.test.Child");
			//两种方式获得注解
			boolean isExist = c.isAnnotationPresent(DefineAnn.class);
			if(isExist){
				DefineAnn d = (DefineAnn) c.getAnnotation(DefineAnn.class);
				System.out.println(d.value());
			}
			
			//通过遍历方法获得其方法注解
			Method[] ms = c.getMethods();
			for (Method method : ms) {
				boolean isMExist = method.isAnnotationPresent(DefineAnn.class);
				if(isMExist){
					DefineAnn a = (DefineAnn) method.getAnnotation(DefineAnn.class);
					System.out.println(a.value());
				}
			}
			
			//通过遍历注释获得 类和方法的注解
			for (Method m : ms) {
				Annotation[] as =  m.getAnnotations();
				for (Annotation an : as) {
					if(an instanceof DefineAnn){
						DefineAnn ann = (DefineAnn)an;
						System.out.println(ann.value());
					}
				}
				
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}





















