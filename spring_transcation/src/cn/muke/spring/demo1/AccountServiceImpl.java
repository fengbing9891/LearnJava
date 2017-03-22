package cn.muke.spring.demo1;

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

	//ע��transactionTemplate���ʽ�������ģ��
	private TransactionTemplate transactionTemplate;
	
	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}

	/**
	 * 
	 * @param out	:ת���˺�
	 * @param in	:ת���˺�
	 * @param money :ת�˽��
	 */
	public void transfer(final String out, final String in, final Double money) {
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
				accountDao.outMoney(out, money);
				int i = 1/0;
				accountDao.inMoney(in, money);
			}
		});
	}

}
