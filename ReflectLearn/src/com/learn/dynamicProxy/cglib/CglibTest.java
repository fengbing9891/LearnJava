package com.learn.dynamicProxy.cglib;

public class CglibTest {

	//ʹ��CGLibʵ�ֶ�̬����CGLibʹ���˷ǳ��ײ���ֽ��뼼������ԭ����ͨ���ֽ��뼼��Ϊһ���ഴ�����࣬
	//���������в��÷������صļ����������и��෽���ĵ��ã�˳��֯������߼���JDK��̬�����CGLib��̬����
	//����ʵ��Spring AOP�Ļ���
	
	//CGLib�����Ķ�̬����������ܱ�JDK�����Ķ�̬�����������ܸ߲��٣�����CGLib�ڴ����������ʱ�����ѵ�ʱ��ȴ��JDK��ö࣬
	//���Զ��ڵ����Ķ�����Ϊ����Ƶ������������CGLib���ʣ���֮��ʹ��JDK��ʽҪ��Ϊ����һЩ��ͬʱ������CGLib�����ǲ��ö�̬��������ķ�����
	//����final�������޷����д���
	public static void main(String[] args) {
		CglibProxy cglib = new CglibProxy();
		//ͨ����������ķ�ʽ����������
		SayHello s = (SayHello) cglib.getProxy(new SayHello());
		s.say();
	}
}
