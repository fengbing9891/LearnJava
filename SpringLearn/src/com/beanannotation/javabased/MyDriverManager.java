package com.beanannotation.javabased;

/**
 * ������Դ�ļ�config.properties�е����� ����:jdbc.properties,��ͨ��value="${}"��ʽд��DriverManagerDataSource��
 * �������Ǵ�config.properties�л�ȡ���ݣ���д�뵽һ��bean��
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
