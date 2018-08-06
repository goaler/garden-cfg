package org.garden.cfg.config;

import org.garden.cfg.intecepter.AuthIntecepter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new AuthIntecepter()).excludePathPatterns("/page", "*.html");
		WebMvcConfigurer.super.addInterceptors(registry);
	}
	
}
