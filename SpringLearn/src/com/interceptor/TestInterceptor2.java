package com.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class TestInterceptor2 implements HandlerInterceptor {

	//请求结束之后才进行调用
	//请求已经被响应结束后，视图已被展示后，调用的方法，资源、流被销毁
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("您现在进入了afterCompletion2 方法");
	}

	//在请求处理之后进行调用
	//可以通过ModelAndView参数改变显示的视图，或修改发往视图的数据
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		System.out.println("您现在进入了postHandle2 方法");
	}

	//在请求处理之前进行调用
	//返回值：表示我们是否要将当前的请求拦截下来
	//如果返回false，请求将被终止
	//如果返回true，请求会被继续运行
	//Object arg2 表示的是被拦截的请求的目标的对象
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
		System.out.println("您现在进入了preHandle2 方法");
		//用拦截器方式解决乱码问题
		arg0.setCharacterEncoding("UTF-8");
		
		//解决用户权限验证问题，如果用户没有登录，则跳转到登录页面
		//对用户是否登录进行判断
		if(arg0.getSession().getAttribute("user") == null){
			//如果用户没有登录，就终止请求，并发送到登录页面
			arg0.getRequestDispatcher("/login.jsp").forward(arg0, arg1);
			return false;
		}
		return true;
	}

}
