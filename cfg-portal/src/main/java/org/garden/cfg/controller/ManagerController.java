package org.garden.cfg.controller;

import javax.servlet.http.HttpServletRequest;

import org.garden.cfg.constant.CfgSysConstant;
import org.garden.cfg.controller.obj.LoginReq;
import org.garden.cfg.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cfg")
public class ManagerController {

	@Autowired
	private ManagerService managerService;

	@Autowired
	private HttpServletRequest request;
	
	@PostMapping("login")
	public boolean login(@RequestBody LoginReq req) {
		if (StringUtils.isEmpty(req.getUserCode()) || StringUtils.isEmpty(req.getPassword())) {
			return false;
		}
		boolean flag = managerService.login(req.getUserCode(), req.getPassword());
		if (flag) {
			request.getSession().setAttribute(CfgSysConstant.user_code_key, req.getUserCode());
			return true;
		}
		return false;
	}
	
	@GetMapping("logout")
	public boolean loginOut() {
		request.getSession().removeAttribute(CfgSysConstant.user_code_key);
		return true;
	}
	
}
