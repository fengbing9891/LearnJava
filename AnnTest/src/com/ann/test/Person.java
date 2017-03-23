package com.ann.test;

import define.DefineAnn;

public interface Person {

	public String name();
	
	public int age();
	
	//¹ıÊ±ÁË
	@Deprecated
	public void sing();
}
