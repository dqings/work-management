package com.dqings.wm.workmanagement.controller.user;

import com.dqings.wm.workmanagement.annotation.Pass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @auther: dongqing
 * @date: 2019/8/30 15:13
 * @description:
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @RequestMapping("/login")
    @Pass
    public String login(){
        LOG.info("跳转登录");
        return "/user/login";
    }

    @RequestMapping("/register")
    @Pass
    public String register(){
        return "/user/register";
    }

}
