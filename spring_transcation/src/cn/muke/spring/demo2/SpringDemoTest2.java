package cn.muke.spring.demo2;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Sping的声明式事务管理的方式一的测试类：   TransactionProxyFactoryBean代理模式
 * @author WBF
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext2.xml")	//引入配置文件
public class SpringDemoTest2 {

	/**
	 * 注入代理类：因为代理类进行增强的操作
	 */
//	@Resource(name="accountService")
	@Resource(name="accountServiceProxy")
	private AccountService accountService;
	
	@Test
	public void demo2(){
		accountService.transfer("aaa", "bbb", 200d);
	}
	
}










