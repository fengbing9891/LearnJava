package com.ann.test;

import define.DefineAnn;

//3)ʹ���Զ���ע��
//ʹ��ע����﷨��
//@<ע����>(<��Ա��1>=<��Աֵ1>,<��Ա��2>=<��Աֵ2>,...)
@DefineAnn("I am class annotation")
public class Child implements Person{

	@Override
	@DefineAnn("I am method annotation")
	public String name() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int age() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void sing() {
		// TODO Auto-generated method stub
		
	}

	
}
