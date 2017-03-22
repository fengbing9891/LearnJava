package cn.muke.spring.demo3;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Sping的声明式事务管理的方式二： 基于AspectJ的XML方式的配置
 * @author WBF
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext3.xml")	//引入配置文件
public class SpringDemoTest3 {

	@Resource(name="accountService")
	private AccountService accountService;
	
	@Test
	public void test3(){
		accountService.transfer("aaa", "bbb", 200d);
	}
	
}
