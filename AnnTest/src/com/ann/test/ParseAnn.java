package com.ann.test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import define.DefineAnn;

public class ParseAnn {

	public static void main(String[] args) {
		try {
			//ʹ���������������
			Class c = Class.forName("com.ann.test.Child");
			//���ַ�ʽ���ע��
			boolean isExist = c.isAnnotationPresent(DefineAnn.class);
			if(isExist){
				DefineAnn d = (DefineAnn) c.getAnnotation(DefineAnn.class);
				System.out.println(d.value());
			}
			
			//ͨ��������������䷽��ע��
			Method[] ms = c.getMethods();
			for (Method method : ms) {
				boolean isMExist = method.isAnnotationPresent(DefineAnn.class);
				if(isMExist){
					DefineAnn a = (DefineAnn) method.getAnnotation(DefineAnn.class);
					System.out.println(a.value());
				}
			}
			
			//ͨ������ע�ͻ�� ��ͷ�����ע��
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





















