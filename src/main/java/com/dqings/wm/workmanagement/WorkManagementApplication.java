package com.dqings.wm.workmanagement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SpringBootApplication
@MapperScan("com.dqings.wm.workmanagement.mapper")
public class WorkManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkManagementApplication.class, args);
	}

	@Bean
	public InternalResourceViewResolver setupViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/jsp/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

}
