package com.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class TestInterceptor implements HandlerInterceptor {

	//请求结束之后才进行调用
	//请求已经被响应结束后，视图已被展示后，调用的方法，资源、流被销毁
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("您现在进入了afterCompletion 方法");
	}

	//在请求处理之后进行调用
	//可以通过ModelAndView参数改变显示的视图，或修改发往视图的数据
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		System.out.println("您现在进入了postHandle 方法");
	}

	//在请求处理之前进行调用
	//返回值：表示我们是否要将当前的请求拦截下来
	//如果返回false，请求将被终止
	//如果返回true，请求会被继续运行
	//Object arg2 表示的是被拦截的请求的目标的对象
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("您现在进入了preHandle 方法");
		return true;
	}

}
