package cn.muke.spring.demo2;

/**
 * ת�˰�����ҵ���ӿ�
 * @author WBF
 *
 */
public interface AccountService {

	/**
	 * 
	 * @param out	:ת���˺�
	 * @param in	:ת���˺�
	 * @param money :ת�˽��
	 */
	public void transfer(String out, String in, Double money);
}
