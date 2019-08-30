package com.dqings.wm.workmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @auther: dongqing
 * @date: 2019/8/30 15:20
 * @description:
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
