package cn.muke.spring.demo3;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Sping������ʽ�������ķ�ʽ���� ����AspectJ��XML��ʽ������
 * @author WBF
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext3.xml")	//���������ļ�
public class SpringDemoTest3 {

	@Resource(name="accountService")
	private AccountService accountService;
	
	@Test
	public void test3(){
		accountService.transfer("aaa", "bbb", 200d);
	}
	
}
