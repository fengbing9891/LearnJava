package com.aop.schema.advice;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 面向切面编程 AOP 
 * @author WBF
 *
 */
public class MoocAspect {

	public void before(){
		System.out.println("MoocAspect   before");
	}
	
	public void afterReturning(){
		System.out.println("MoocAspect   afterReturning");
	}
	
	
	public void afterThrowing(){
		System.out.println("MoocAspect   afterThrowing");
	}
	
	public void after(){
		System.out.println("MoocAspect   after");
	}
	
	public Object around(ProceedingJoinPoint pjp){
		Object obj = null;
		try {
			System.out.println("MoocAspect   around   1");
			obj =  pjp.proceed();
			System.out.println("MoocAspect   around   2");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
	
	public Object aroundInit(ProceedingJoinPoint pjp,String bizName, int times){
		System.out.println(bizName + "  " + times);
		Object obj = null;
		try {
			System.out.println("MoocAspect   aroundInit   1");
			obj =  pjp.proceed();
			System.out.println("MoocAspect   aroundInit   2");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}

	
}
