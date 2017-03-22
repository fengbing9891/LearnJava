package cn.muke.spring.demo2;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Sping������ʽ�������ķ�ʽһ�Ĳ����ࣺ   TransactionProxyFactoryBean����ģʽ
 * @author WBF
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext2.xml")	//���������ļ�
public class SpringDemoTest2 {

	/**
	 * ע������ࣺ��Ϊ�����������ǿ�Ĳ���
	 */
//	@Resource(name="accountService")
	@Resource(name="accountServiceProxy")
	private AccountService accountService;
	
	@Test
	public void demo2(){
		accountService.transfer("aaa", "bbb", 200d);
	}
	
}










