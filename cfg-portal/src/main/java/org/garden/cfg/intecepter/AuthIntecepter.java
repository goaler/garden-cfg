package org.garden.cfg.intecepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.garden.cfg.constant.CfgSysConstant;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthIntecepter extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Object userCode = request.getSession().getAttribute(CfgSysConstant.user_code_key);
		if (userCode == null) {
		    response.sendRedirect("/page/login.html");
			return false;
		}
		request.setAttribute(CfgSysConstant.user_code_key, userCode);
		
		return true;
	}

}
