package com.interceptor;


import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

public class TestInterceptor3 implements WebRequestInterceptor {

	@Override
	public void afterCompletion(WebRequest arg0, Exception arg1)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(WebRequest arg0, ModelMap arg1) throws Exception {
		// TODO Auto-generated method stub
		
	}

	//无返回值，不能终止请求
	@Override
	public void preHandle(WebRequest arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
