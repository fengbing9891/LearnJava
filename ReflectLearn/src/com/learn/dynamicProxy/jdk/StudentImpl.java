package com.learn.dynamicProxy.jdk;

public class StudentImpl implements Student {

	@Override
	public void login() {
		System.out.println("��¼");
	}

	@Override
	public void submit() {
		System.out.println("�ύ");
	}

}
