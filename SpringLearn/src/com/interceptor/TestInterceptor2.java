package com.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class TestInterceptor2 implements HandlerInterceptor {

	//�������֮��Ž��е���
	//�����Ѿ�����Ӧ��������ͼ�ѱ�չʾ�󣬵��õķ�������Դ����������
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("�����ڽ�����afterCompletion2 ����");
	}

	//��������֮����е���
	//����ͨ��ModelAndView�����ı���ʾ����ͼ�����޸ķ�����ͼ������
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		System.out.println("�����ڽ�����postHandle2 ����");
	}

	//��������֮ǰ���е���
	//����ֵ����ʾ�����Ƿ�Ҫ����ǰ��������������
	//�������false�����󽫱���ֹ
	//�������true������ᱻ��������
	//Object arg2 ��ʾ���Ǳ����ص������Ŀ��Ķ���
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
		System.out.println("�����ڽ�����preHandle2 ����");
		//����������ʽ�����������
		arg0.setCharacterEncoding("UTF-8");
		
		//����û�Ȩ����֤���⣬����û�û�е�¼������ת����¼ҳ��
		//���û��Ƿ��¼�����ж�
		if(arg0.getSession().getAttribute("user") == null){
			//����û�û�е�¼������ֹ���󣬲����͵���¼ҳ��
			arg0.getRequestDispatcher("/login.jsp").forward(arg0, arg1);
			return false;
		}
		return true;
	}

}
