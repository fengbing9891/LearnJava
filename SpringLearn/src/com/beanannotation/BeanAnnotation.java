package com.beanannotation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * bean定义及作用域的注解实现  注解 
 * @Component 通用注解，适用于所有bean 两种方式，bean的id：一种是自动生成，类名首字母小写（BeanAnnotation:beanAnnotation）
 * 			另一种是自己写：@Component("bean")
 * @Scope  标识作用域
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
