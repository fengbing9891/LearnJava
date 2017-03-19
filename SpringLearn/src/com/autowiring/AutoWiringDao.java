package com.autowiring;
/**
 *  根据 byName byType constructor 方式实现自动装配
 * @author WBF
 *
 */
public class AutoWiringDao {

	public void say(String word){
		System.out.println("AutoWiringDao : " + word);
	}
}
