package com.ann.test;

import define.DefineAnn;

//3)使用自定义注解
//使用注解的语法：
//@<注解名>(<成员名1>=<成员值1>,<成员名2>=<成员值2>,...)
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
