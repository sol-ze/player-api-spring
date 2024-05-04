package com.sol.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.sol.dao.PlayerDAO;
import com.sol.dao.PlayerDAOImpl;


@EnableWebMvc
@Configuration
@ComponentScan(basePackages = {"com.sol.controller"})
@PropertySources({@PropertySource("classpath:application.properties")})
public class AppConfig implements WebMvcConfigurer {

	@Autowired
	ApplicationContext applicationContext;
	
	@Autowired
	private Environment env;
	
	
	
	@Bean
	DriverManagerDataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
		ds.setUrl(env.getProperty("spring.datasource.url"));
		ds.setUsername(env.getProperty("spring.datasource.username"));
		ds.setPassword(env.getProperty("spring.datasource.password"));
		return ds;
	}
	
	@Bean
	public PlayerDAO getUserDAO() {
		return new PlayerDAOImpl(getDataSource());
	}
	
}
