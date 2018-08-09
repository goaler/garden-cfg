package org.garden.cfg.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class SysController implements ErrorController{

	public static final String ERROR_PATH = "/error";

    @RequestMapping(ERROR_PATH)
    public String handleError(HttpServletResponse resp) {
    	return "error"; 
    }

	@Override
	public String getErrorPath() {
		return ERROR_PATH;
	}

}