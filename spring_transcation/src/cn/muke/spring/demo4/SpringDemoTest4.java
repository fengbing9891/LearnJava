package cn.muke.spring.demo4;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Sping������ʽ�������ķ�ʽ���� ����ע�ⷽʽ
 * @author WBF
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext4.xml")	//���������ļ�
public class SpringDemoTest4 {

	@Resource(name="accountService")
	private AccountService accountService;
	
	@Test
	public void test4(){
		accountService.transfer("aaa", "bbb", 200d);
	}
	
}
