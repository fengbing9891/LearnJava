package com.learn;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


/**
 * ����
 * @author WBF
 *
 */
public class Reflect {
	//������״̬�У���������һ���࣬���ܹ���ȡ���������������Ժͷ����������κ�һ�����󣬶��ܹ���������
	//����һ�����������ԣ�����˽�еķ��������ԣ������ֶ�̬��ȡ����Ϣ���߶�̬���ö���ķ����Ĺ��ܾͳ�Ϊ
	//java���Եķ�����ơ�ͨ�׵㽲��ͨ�����䣬�����������͸���ģ���Ҫ��ȡ�κζ��������ԡ�
	
	//��Ҫʹ�÷�����ƣ��ͱ������ֽ����ļ�����.class����ͨ���ֽ����ļ����󣬾��ܹ�ͨ�������еķ���
	//��ȡ��������Ҫ��������Ϣ�����������ԣ���������������ʵ�ֵ����нӿڵȵȣ���ÿһ�����Ӧ��һ���ֽ���
	//�ļ�Ҳ�Ͷ�Ӧ��һ��Class���͵Ķ���Ҳ�����ֽ����ļ�����
	
	public void learnReflect(){
		//��ȡ�ֽ����ļ���������ַ�ʽ
		
		//1.ͨ��Class���еľ�̬����forName,ֱ�ӻ�ȡ��һ������ֽ����ļ����󣬴�ʱ���໹��Դ�ļ��׶Σ���û�б�Ϊ�ֽ����ļ�
		try {
			Class class1 = Class.forName("com.learn.Person");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	//���ز���ָ�����࣬���ҳ�ʼ������
		
		//2.���౻���س�.class�ļ�ʱ����ʱPerson������.class���ڻ�ȡ���ֽ����ļ�����Ҳ���ǻ�ȡ�Լ������ദ���ֽ���׶�
		Class class2 = Person.class;
		
		//3.ͨ�����ʵ����ȡ������ֽ����ļ����󣬸��ദ�ڴ�������׶�
		Person p = new Person();
		Class class3 =  p.getClass();
	}

	//�����ֽ����ļ�������ܻ�����е�������Ϣ��������ʹ�÷����ȡ��Ϣʱ��ҲҪ����ʹ���������ַ�ʽ��ȡ
	//�ֽ����������Ӳ�ͬ���������
	
	
	public static void main(String[] args) {
		//ͨ�����䣬�ڷ���Ϊint��arryaList�����д��һ��String���͵Ķ���
		//ԭ�������з���ֻ�ڱ�������Ч�������������ڣ��������ʧЧ
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
//		list.add("aaa");	�ڱ����ڣ�������Ч�������ַ��������򱨴�
		try {
			Class class1 = list.getClass();	//������ֽ����ļ�����
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
