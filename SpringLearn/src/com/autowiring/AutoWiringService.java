package com.autowiring;

/**
 * 根据 byName byType constructor 方式实现自动装配
 * @author WBF
 *
 */
public class AutoWiringService {

	private AutoWiringDao autoWiringDao;
	
	public AutoWiringService(AutoWiringDao autoWiringDao){
		System.out.println("AutoWiringService");
		this.autoWiringDao = autoWiringDao;
	}
	
	public void setAutoWiringDao(AutoWiringDao autoWiringDao) {
		System.out.println("setAutoWiringDao");
		this.autoWiringDao = autoWiringDao;
	}


	public void say(String word){
		this.autoWiringDao.say(word);
	}
}
