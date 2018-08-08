package org.garden.cfg.intecepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.garden.cfg.constant.CfgSysConstant;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthIntecepter extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println(request.getRequestURI());
		Object userCode = request.getSession().getAttribute(CfgSysConstant.user_code_key);
		if (userCode == null) {
			//如果未登录
			String req_source = request.getHeader(CfgSysConstant.req_source_key);
			if (CfgSysConstant.req_source_axios.equals(req_source)) {
				response.setStatus(HttpStatus.UNAUTHORIZED.value());
			}else {				
				response.sendRedirect("/page/login.html");
			}
			return false;
		}
		request.setAttribute(CfgSysConstant.user_code_key, userCode);
		
		return true;
	}

}
