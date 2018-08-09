package org.garden.cfg.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SysController implements ErrorController{

	public static final String ERROR_PATH = "/error";

    @RequestMapping(ERROR_PATH)
    public String handleError(HttpServletResponse resp) {
    	if (resp.getStatus() == 404) {			
    		return "login";
		}
    	return "/error";
    }

	@Override
	public String getErrorPath() {
		return ERROR_PATH;
	}

}