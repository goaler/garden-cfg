package org.garden.cfg.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.garden.cfg.constant.CfgSysConstant;
import org.garden.cfg.controller.obj.LoginReq;
import org.garden.cfg.core.util.CfgUtils;
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
	public String login(@RequestBody LoginReq req) {
		if (StringUtils.isEmpty(req.getUserCode()) || StringUtils.isEmpty(req.getPassword())) {
			return null;
		}
		boolean flag = managerService.login(req.getUserCode(), req.getPassword());
		if (flag) {
			String token = UUID.randomUUID().toString();
			CfgUtils.getUserInfos().put(token, req.getUserCode());
			return token;
		}
		return null;
	}
	
	@GetMapping("logout")
	public boolean loginOut() {
		CfgUtils.getUserInfos().remove(request.getHeader(CfgSysConstant.key_token));
		return true;
	}
	
}
