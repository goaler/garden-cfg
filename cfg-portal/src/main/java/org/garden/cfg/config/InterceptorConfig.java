package org.garden.cfg.config;

import java.util.ArrayList;
import java.util.List;

import org.garden.cfg.intecepter.AuthIntecepter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		List<String> patterns = new ArrayList<>();
		patterns.add("/img/**");
		patterns.add("/js/**");
		patterns.add("/page/**");
		patterns.add("/cfg/login");
		patterns.add("/cfg/logout");
		registry.addInterceptor(new AuthIntecepter()).excludePathPatterns(patterns);
		WebMvcConfigurer.super.addInterceptors(registry);
	}
	
}
