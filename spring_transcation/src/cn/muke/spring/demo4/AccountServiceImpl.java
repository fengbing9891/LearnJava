package cn.muke.spring.demo4;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


/**
 * ת�˰�����ҵ���ʵ����
 * @author WBF
 *
 */
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,readOnly=false)
public class AccountServiceImpl implements AccountService {

	//ע��ת�˵�DAO����
	private AccountDao accountDao;
	
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	/**
	 * 
	 * @param out	:ת���˺�
	 * @param in	:ת���˺�
	 * @param money :ת�˽��
	 */
	public void transfer(String out, String in, Double money) {
		accountDao.outMoney(out, money);
		int i = 1/0;
		accountDao.inMoney(in, money);
	}

}
