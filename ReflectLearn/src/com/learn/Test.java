package com.learn;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {

	public static void main(String[] args) {
		
		try {
			//1.ͨ���ֽ�����󴴽�ʵ������
			//User�໹û�м��أ���Դ�ļ��׶ξͻ�ȡ���ֽ����ļ�����
			Class class1 = Class.forName("com.learn.User");
			//����userʵ����������ͨ��User���޲ι��캯���������Ķ���
			User user = (User) class1.newInstance();
			
			//2.��ȡָ�����췽����constructor���û���޲ι��죬ֻ���вι�����δ���ʵ����
			//��ȡ�ֽ����ļ�
//			Class class2 = Class.forName("com.learn.User");
			//�Ȼ�ȡ�вι�������parameterTypes:��ʾ�����б��ж���д���٣�Ҳ���Բ�д����д���ǵ����޲ι�������
			Constructor constructor = class1.getConstructor(int.class, String.class);
			//ͨ����������ʵ�������󣬽�ʵ�ʵĲ�������ȥ
			User user2 = (User) constructor.newInstance(12, "С��");
			
			//��ȡ���й��췽��
			Constructor[] constructors = class1.getConstructors();
			for (int i = 0; i < constructors.length; i++) {
				//��ȡÿ�����캯���еĲ��������ֽ������
				Class[] parameterTypes = constructors[i].getParameterTypes();
				System.out.println("��ȡ��" + i + "�����캯��");
				for (int j = 0; j < parameterTypes.length; j++) {
					//��ȡ���캯���еĲ�������
					System.out.println(parameterTypes[i].getName() + ",");
				}
			}
			
			//3.��ȡ��Ա������ʹ�� Field����
			//��ȡ��Ա����: class1.getField(name); ͨ��name����ȡָ����Ա����
			//����ó�Ա����Ϊ˽�еģ���Ӧ��ʹ��getDeclaredField(name)
			Field field = class1.getDeclaredField("id");
			//��Ϊ������˽�еģ���������Զ���󣬻�Ҫ����򿪿ɼ�Ȩ��
			field.setAccessible(true);
			//�����Ա�������в�������ֵ����	
			field.setInt(user, 5);	//ͨ��set(obj, "����")������������ָ�������ϸ��ֶε�ֵ
			//��ȡ��Ա������ֵ��field.get(obj)�� objΪ�������ֶε�ֵ�ö���Ҳ���Ǹ����Զ�Ӧ���ʵ������
			System.out.println(field.getInt(user));		//get(obj)���Ի�ȡָ�������и��ֶε�ֵ
			
			//��ȡȫ����Ա����
			Field[] fields = class1.getDeclaredFields();	//��˽�е�����Ҳһ�����
			for (int i = 0; i < fields.length; i++) {
				fields[i].setAccessible(true); //��Ȩ�޴�
				System.out.println(fields[i].get(user));	//��ȡ��Ա������ֵ
			}
			
			
			//4.��÷�����ʹ��	Method
			//���������ķ�����learnΪ����������public����
			/**
			 * class1.getMethod(name, parameterTypes)
			 * name:����������
			 * parameterTypes�������Ĳ������͵�Class���ͣ�û����ʲô������������ΪString������String.class
			 * 
			 */
			Method method = class1.getMethod("learn");
			//���÷���
			/**
			 * method.invoke(obj, args)
			 * obj:�����Ķ���
			 * args��ʵ�ʵĲ���ֵ��û������
			 */
			method.invoke(user, null);
			
			//�������ķ�����singΪ��һ��String���Ͳ����ķ���
			Method method1 = class1.getMethod("sing", String.class);
			method1.invoke(user, "�ɶ�");
			
			//��ȡ˽�еķ������ͻ�ȡ˽�е�����һ����sayΪ˽�з���
			Method method2 = class1.getDeclaredMethod("say");
			method2.setAccessible(true);
			method2.invoke(user);	//���Ե��ø÷���
			
			//һ���Ի�����еķ���
			Method[] methods = class1.getDeclaredMethods();
			for (Method m : methods) {
				m.setAccessible(true);
				System.out.println(m.getName());
				//��÷����Ĳ���
				Class<?>[] parameterTypes = m.getParameterTypes();
				for (int i = 0; i < parameterTypes.length; i++) {
					System.out.println(parameterTypes[i].getName()+",");
				}
			}
			
			//��ø�������нӿ�	����ֵ���ӿڵ��ֽ����ļ����������
			Class[] interfaces = class1.getInterfaces();	//ȷ���˶�������ʾ�����ӿ�ʵ�ֵĽӿ�
		
			
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
