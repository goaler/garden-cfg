package org.garden.cfg.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	
	@GetMapping("login")
	public String login(String userCode, String password) {
		return "success";
	}

}
