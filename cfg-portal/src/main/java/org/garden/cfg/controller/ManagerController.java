package org.garden.cfg.controller;

import javax.servlet.http.HttpServletRequest;

import org.garden.cfg.controller.obj.LoginReq;
import org.garden.cfg.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
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
			request.getSession().setAttribute("userCode", req.getUserCode());
			return true;
		}
		return false;
	}

}
