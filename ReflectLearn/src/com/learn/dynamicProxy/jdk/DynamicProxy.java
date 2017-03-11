package com.learn.dynamicProxy.jdk;

import java.lang.reflect.Proxy;

public class DynamicProxy {

	//��̬����һ�����ģʽ����ǳ��򵥣���������⣺������Լ�������£����Ǿ����Լ����ǳ��鷳���߲����㣬���Ծͽ���һ���ˣ�����
	//��������������飬����Ͳ��ù��ˣ�����Ƕ�̬�����ٸ����ӣ����Ʊ���˴���
	//�ڳ������й����в�����������󣬶��������й����в���������ʵ���Ƿ��佲������ݣ����ԣ���̬������ʵ����ͨ������������һ������
	//��java��java.lang.reflect�����ṩ��һ��Proxy���һ��InvocationHandler�ӿڣ�ͨ��ʹ�������ͽӿھͿ������ɶ�̬�������JDK
	//�ṩ�Ĵ���ֻ����Խӿ������������и�ǿ���cglib��Proxy���еķ���������̬���������
	
	//������������ע��JDK�ṩ�Ĵ���ֻ����Խӿ�������Ҳ��������ĵڶ������صı���Ҫ��һ���ӿڡ�
	
	//1.new���������ͨ��ʵ��InvacationHandler�ӿڣ�Ȼ��new�������������
	//2.ͨ��Proxy���еľ�̬����newProxyInstanse��������������װ���Ǹ�������Ķ���Ҳ����������˰����Ǵ����Ʊһ�����Ǹ�����
	//�ͼ�װ�������Լ�����
	//3.ִ�з���������ɹ���
	
	public static void main(String[] args) {
		StudentImpl si = new StudentImpl();	//���������
		MyInvocationHandler m = new MyInvocationHandler(si);	//new���������
		//newProxyInstance��������������һ��������������ڶ��������������Ľӿڣ�	���������������
		Student s = (Student) Proxy.newProxyInstance(si.getClass().getClassLoader(), si.getClass().getInterfaces(), m);	//����������װ���Ǹ�������Ķ���
		s.login();
		s.submit();
	}
	
}
