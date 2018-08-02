package org.garden.cfg.controller;

import javax.servlet.http.HttpServletRequest;

import org.garden.cfg.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManagerController {

	@Autowired
	private ManagerService managerService;

	@Autowired
	private HttpServletRequest request;

	@GetMapping("login")
	public boolean login(String userCode, String password) {
		if (StringUtils.isEmpty(userCode) || StringUtils.isEmpty(password)) {
			return false;
		}
		boolean flag = managerService.login(userCode, password);
		if (flag) {
			request.getSession().setAttribute("userCode", userCode);
		}
		return true;
	}

}
