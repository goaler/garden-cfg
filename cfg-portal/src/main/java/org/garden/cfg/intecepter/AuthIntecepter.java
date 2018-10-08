
package org.garden.cfg.intecepter;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.garden.cfg.constant.CfgSysConstant;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * session中保持登录信息
 * @author goaler
 *
 */
@Deprecated
public class AuthIntecepter extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		// 判断用户是否登录
		Object userCode = request.getSession().getAttribute(CfgSysConstant.key_user_code);
		if (userCode == null) {
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
			response.sendRedirect("/page/login.html");
		}
	}
}
