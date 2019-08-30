package com.dqings.wm.workmanagement.intercepter;

import com.dqings.wm.workmanagement.annotation.Pass;
import com.dqings.wm.workmanagement.enums.ConstantEnum;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @auther: dongqing
 * @date: 2019/8/30 15:30
 * @description:
 */
@Configuration
public class LoginIntercepter  implements HandlerInterceptor {

    private static final String LOGIN = "/user/login";

    @Bean
    public LoginIntercepter getLoginIntercepter(){
        return new LoginIntercepter();
    }
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute(ConstantEnum.USER.getCode());
        if(user!=null) return true;
        if(handler instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod)handler;
            Pass pass = handlerMethod.getMethodAnnotation(Pass.class);
            if(pass!=null) return true;
        }
        response.sendRedirect(LOGIN);
        return false;
    }



}
