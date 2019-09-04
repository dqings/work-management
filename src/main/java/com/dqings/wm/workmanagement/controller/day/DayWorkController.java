package com.dqings.wm.workmanagement.controller.day;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @auther: dongqing
 * @date: 2019/9/4 12:38
 * @description:
 */
@Controller
@RequestMapping("/day")
public class DayWorkController {

    @RequestMapping("/work")
    public String work(){
        return "/day/dayWork";
    }

    @RequestMapping("/backPlan")
    public String backPlan(){
        return "/day/backPlan";
    }

}
