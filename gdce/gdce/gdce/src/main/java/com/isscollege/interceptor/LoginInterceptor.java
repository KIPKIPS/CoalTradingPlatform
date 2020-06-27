/**
 * 
 */
package com.isscollege.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Apple
 *
 */
// 创建用户登录校验拦截器
public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object o) throws Exception {
		HttpSession session = req.getSession();
		// session已超时，用户信息不存在，直接跳转登录页面
		if (session.getAttribute("admin") == null && session.getAttribute("trader") == null
				&& session.getAttribute("finance") == null) {
			resp.setContentType("text/html; charset=GB2312");
			PrintWriter out = resp.getWriter();
			out.print("<script>window.top.location.href='" + session.getServletContext().getContextPath()
					+ "/admin/index';</script>");
			out.close();

			return false;
		} else {// session未超时，用户信息存在
			return true;
		}
	}

}
