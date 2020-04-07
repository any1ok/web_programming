package kr.or.connect.payment.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import kr.or.connect.payment.config.DBConfig;

@Configuration
@ComponentScan(basePackages= {"kr.or.connect.payment.dao","kr.or.connect.payment.service"})
@Import({ DBConfig.class })
public class ApplicationConfig {

}
