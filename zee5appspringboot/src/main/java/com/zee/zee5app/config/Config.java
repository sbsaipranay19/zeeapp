package com.zee.zee5app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.zee.zee5app.utils.PasswordUtils;

@Configuration
//@ComponentScan("com.zee.zee5app")
//@PropertySource("classpath:application.properties")

public class Config {
	@Autowired
	Environment environment;

//	@Bean(name="ds")
//	@Scope("prototype")
//	public DataSource dataSource() {
//		BasicDataSource basicDataSource = new BasicDataSource();
//		basicDataSource.setUsername(environment.getProperty("jdbc.username"));
//		basicDataSource.setPassword(environment.getProperty("jdbc.password"));
//		basicDataSource.setUrl(environment.getProperty("jdbc.url"));
//		basicDataSource.setInitialSize(5);
//		basicDataSource.setDefaultAutoCommit(false);
//		
//		return basicDataSource;
//	}
	@Bean
	public PasswordUtils passwordUtils() {
		return new PasswordUtils();
	}
}
