package cn.muke.spring.demo4;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Sping的声明式事务管理的方式三： 基于注解方式
 * @author WBF
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext4.xml")	//引入配置文件
public class SpringDemoTest4 {

	@Resource(name="accountService")
	private AccountService accountService;
	
	@Test
	public void test4(){
		accountService.transfer("aaa", "bbb", 200d);
	}
	
}
