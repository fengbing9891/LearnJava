package com.dao.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//@Target	@Retention	元注解
//ElementType.TYPE：说明该注解只能被声明在一个类前
//ElementType.FIELD：说明该注解只能被声明在一个类的字段前
//ElementType.METHOD：说明该注解只能被声明在一个类的方法前
//ElementType.PARAMETER：说明该注解只能被声明在一个方法参数前
//ElementType.CONSTRUCTOR：说明该注解只能声明在一个类的构造方法前
//ElementType.LOCAL_VARIABLE：说明该注解只能声明在一个局部变量前
//ElementType.ANNOTATION_TYPE：说明该注解只能声明在一个注解类型前
//ElementType.PACKAGE：说明该注解只能声明在一个包名前

@Target(ElementType.FIELD)	//用来说明该注解可以被声明在哪些元素之前
@Retention(RetentionPolicy.RUNTIME)	//用来说明该注解类的生命周期	RetentionPolicy.SOURCE:注解只保留在源文件中	RetentionPolicy.CLASS:注解保留在class文件中，在加载到JVM虚拟机时丢弃  	RetentionPolicy.RUNTIME:注解保留在程序运行期间，此时可以通过反射获得定义在某个类上的所有注解
public @interface Column {		//使用@intreface关键字定义注解	  Java用  @interface Annotation{ } 定义一个注解 @Annotation，一个注解是一个类。
	//1.成员类型是受限的，合法的类型包括原始类型以及String,Class,Annotation,Enumeration
	//可以用default为成员指定一个默认值	int age() default 18；
	//注解类可以没有成员，称之为标识注解	
	//注解类只有一个成员时，必须取名为value()，在使用时可以忽略成员名和赋值号（=）
	
	String value();
}
