package com.beanannotation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * bean���弰�������ע��ʵ��  ע�� 
 * @Component ͨ��ע�⣬����������bean ���ַ�ʽ��bean��id��һ�����Զ����ɣ���������ĸСд��BeanAnnotation:beanAnnotation��
 * 			��һ�����Լ�д��@Component("bean")
 * @Scope  ��ʶ������
 * @author WBF
 *
 */
//@Component("bean")
//@Scope("prototype")
@Scope
@Component
public class BeanAnnotation {

	public void say(String param){
		System.out.println("BeanAnnotation : " + param);
	}
	
	public void myHashCode(){
		System.out.println("BeanAnnotation : " + this.hashCode());
	}
	
}
