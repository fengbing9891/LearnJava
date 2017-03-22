package cn.muke.spring.demo2;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * ת�˰�����ҵ���ʵ����
 * @author WBF
 *
 */
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
