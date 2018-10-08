package org.garden.cfg.intecepter;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.garden.cfg.constant.CfgSysConstant;
import org.garden.cfg.core.util.SysUtils;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class DisAuthIntecepter extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
			return true;
		}

		// 判断用户是否登录
		String token = request.getHeader(CfgSysConstant.key_token);
		if (StringUtils.isEmpty(token)) {
			handleUnauth(request, response);
			return false;
		}
		String userCode = SysUtils.getUserInfos().get(token);
		if (StringUtils.isEmpty(userCode)) {
			handleUnauth(request, response);
			return false;
		}
		request.setAttribute(CfgSysConstant.key_user_code, userCode);

		return true;
	}
	

	/**
	 * 处理未登录的请求
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void handleUnauth(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 如果未登录
		String req_source = request.getHeader(CfgSysConstant.key_req_source);
		if (CfgSysConstant.req_source_axios.equals(req_source)) {
			response.setStatus(HttpStatus.UNAUTHORIZED.value());
		} else {
			response.setStatus(HttpStatus.UNAUTHORIZED.value());
//			response.sendRedirect("/page/login.html");
		}
	}
}
