package com.beanannotation.javabased;

/**
 * 加载资源文件config.properties中的内容 例如:jdbc.properties,再通过value="${}"方式写入DriverManagerDataSource中
 * 此例子是从config.properties中获取内容，并写入到一个bean中
 * @author WBF
 *
 */
public class MyDriverManager {

	public MyDriverManager(String url, String username, String password){
		System.out.println("url : "  + url);
		System.out.println("username : "  + username);
		System.out.println("password : "  + password);
	}

}
