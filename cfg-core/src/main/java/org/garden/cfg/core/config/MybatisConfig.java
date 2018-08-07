package org.garden.cfg.core.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("org.garden.cfg.core.repository")
public class MybatisConfig {

}
