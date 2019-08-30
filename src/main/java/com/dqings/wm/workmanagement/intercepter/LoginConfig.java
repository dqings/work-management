package com.dqings.wm.workmanagement.intercepter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @auther: dongqing
 * @date: 2019/8/30 16:31
 * @description:
 */
@Configuration
public class LoginConfig extends WebMvcConfigurationSupport {

    @Autowired
    private LoginIntercepter loginIntercepter;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginIntercepter).addPathPatterns("/*");
        super.addInterceptors(registry);
    }
}
