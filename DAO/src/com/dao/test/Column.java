package com.dao.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//@Target	@Retention	Ԫע��
//ElementType.TYPE��˵����ע��ֻ�ܱ�������һ����ǰ
//ElementType.FIELD��˵����ע��ֻ�ܱ�������һ������ֶ�ǰ
//ElementType.METHOD��˵����ע��ֻ�ܱ�������һ����ķ���ǰ
//ElementType.PARAMETER��˵����ע��ֻ�ܱ�������һ����������ǰ
//ElementType.CONSTRUCTOR��˵����ע��ֻ��������һ����Ĺ��췽��ǰ
//ElementType.LOCAL_VARIABLE��˵����ע��ֻ��������һ���ֲ�����ǰ
//ElementType.ANNOTATION_TYPE��˵����ע��ֻ��������һ��ע������ǰ
//ElementType.PACKAGE��˵����ע��ֻ��������һ������ǰ

@Target(ElementType.FIELD)	//����˵����ע����Ա���������ЩԪ��֮ǰ
@Retention(RetentionPolicy.RUNTIME)	//����˵����ע�������������	RetentionPolicy.SOURCE:ע��ֻ������Դ�ļ���	RetentionPolicy.CLASS:ע�Ᵽ����class�ļ��У��ڼ��ص�JVM�����ʱ����  	RetentionPolicy.RUNTIME:ע�Ᵽ���ڳ��������ڼ䣬��ʱ����ͨ�������ö�����ĳ�����ϵ�����ע��
public @interface Column {		//ʹ��@intreface�ؼ��ֶ���ע��	  Java��  @interface Annotation{ } ����һ��ע�� @Annotation��һ��ע����һ���ࡣ
	//1.��Ա���������޵ģ��Ϸ������Ͱ���ԭʼ�����Լ�String,Class,Annotation,Enumeration
	//������defaultΪ��Աָ��һ��Ĭ��ֵ	int age() default 18��
	//ע�������û�г�Ա����֮Ϊ��ʶע��	
	//ע����ֻ��һ����Աʱ������ȡ��Ϊvalue()����ʹ��ʱ���Ժ��Գ�Ա���͸�ֵ�ţ�=��
	
	String value();
}
