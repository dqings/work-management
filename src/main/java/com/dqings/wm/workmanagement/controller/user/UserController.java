package com.dqings.wm.workmanagement.controller.user;

import com.dqings.wm.workmanagement.annotation.Pass;
import com.dqings.wm.workmanagement.enums.CodeEnum;
import com.dqings.wm.workmanagement.enums.ConstantEnum;
import com.dqings.wm.workmanagement.po.User;
import com.dqings.wm.workmanagement.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @auther: dongqing
 * @date: 2019/8/30 15:13
 * @description:
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

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

    @RequestMapping("/doRegister")
    public String doRegister(User user, HttpServletRequest request, HttpServletResponse response){
        LOG.info("用户注册开始,用户名={},密码={},邮箱={},手机号={}",user.getUserName(),user.getPassword(),user.getEmail(),user.getMobile());
        String result = userService.doRegister(user);
        if(CodeEnum.SUCCESS.getCode().equals(result)){
            LOG.info("注册成功,手机号={}",user.getMobile());
            request.getSession().setAttribute(ConstantEnum.USER.getCode(),user);
            try {
                response.sendRedirect("/index");
            } catch (IOException e) {
                LOG.error("系统异常");
            }
            return "index";
        }
        request.setAttribute("msg","注册失败");
        return "error";
    }

    @RequestMapping("/doLogin")
    public String doLogin(HttpServletResponse response,HttpServletRequest request,User user){
        LOG.info("接收到登录请求,用户名={}",user.getUserName());
        User login = userService.doLogin(user);
        if(login!=null){
            LOG.info("登录成功,用户名={}",user.getUserName());
            request.getSession().setAttribute(ConstantEnum.USER.getCode(),login);
            try {
                response.sendRedirect("/index");
                return "/index";
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        request.setAttribute("msg","用户名或密码错误");
        return "/user/login";
    }

    @RequestMapping("logout")
    public String logout(HttpServletRequest request){
        request.getSession().removeAttribute(ConstantEnum.USER.getCode());
        return "/user/login";
    }


}
