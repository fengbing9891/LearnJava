package com.beanannotation.javabased;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

/**
 * @Beanע��ѧϰ��һ���@Configuration���ʹ�ã�������ɵĹ�������java������bean���൱��xml�е�<bean id="" class=""/>
 * @author WBF
 *
 */
//@import �� @importResource ���ǵ�������һ�����ã�Ȼ������������ﶨ���bean�Ϳ���������������ʹ����
//@Importע��֧�ֵ�����
@Configuration	//�൱��xml�е�<beans>Ԫ��
@ImportResource("classpath:config.xml")		//������xml����ʱ��<import resource="cons-injecxml" />�������XML��ʽ�������ļ�
public class StoreConifg {

	@Value("${jdbc.url}")
	private String url;
	
	//config.properties�ļ���jdbc.username�������Ϊusername,��˴�ȡ����ֵΪ����ϵͳ��¼��
	@Value("${jdbc.username}")
	private String username;
	
	@Value("${jdbc.password}")
	private String password;
	
	//����bean �൱��xml�е�<bean>Ԫ�أ����ض���Ϊbean��������Ϊ��Bean��ID
	@Bean
	public MyDriverManager myDriverManager(){
		return new MyDriverManager(url, username, password);
	}
	
	
	
	//initMethod = "init", destroyMethod = "destroy" �൱��XML�е�init-method,destroy-method
//	@Bean(name = "stringStore", initMethod = "init", destroyMethod = "destroy")
//	public Store stringStore(){
//		return new StringStore();
//	}
	
	//@BeanĬ���ǵ����� proxyMode ����ʽ
//	@Bean
//	@Scope(value ="prototype", proxyMode=ScopedProxyMode.TARGET_CLASS)
//	public Store stringStore(){
//		return new StringStore();
//	}
	
	@Autowired
	private Store<String> s1;
	
	@Autowired
	private Store<Integer> s2;
	
	@Bean
	public StringStore stringStore(){
		return new StringStore();
	}
	
	@Bean
	public IntegerStore integerStore(){
		return new IntegerStore();
	}
	
	@Bean
	public Store stringStoreTest(){
		System.out.println("s1 : " + s1.getClass().getName()); 
		System.out.println("s2 : " + s2.getClass().getName()); 
		return new StringStore();
	}
	
}
