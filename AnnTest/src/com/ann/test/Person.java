package com.ann.test;

import define.DefineAnn;

public interface Person {

	public String name();
	
	public int age();
	
	//��ʱ��
	@Deprecated
	public void sing();
}
