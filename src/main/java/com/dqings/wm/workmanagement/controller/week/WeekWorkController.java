package com.dqings.wm.workmanagement.controller.week;

import com.dqings.wm.workmanagement.po.*;
import com.dqings.wm.workmanagement.service.user.UserService;
import com.dqings.wm.workmanagement.service.week.WeekWorkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @auther: dongqing
 * @date: 2019/9/4 12:38
 * @description:
 */
@Controller
@RequestMapping("/week")
public class WeekWorkController {

    private static final Logger LOG = LoggerFactory.getLogger(WeekWorkController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private WeekWorkService weekWorkService;

    @RequestMapping("/weekPlanInfo")
    public String toWeekPlanInfo(){
        return "/week/weekPlanInfo";
    }

    @RequestMapping("/backPlan")
    public String toBackPlan(){
        return "/week/backPlan";
    }

    @RequestMapping("/getWeekPlanInfo")
    @ResponseBody
    public PageBean<WeekPlanInfo> getWeekPlanInfo(WeekPlanInfoQuery weekPlanInfoQuery, HttpServletRequest request){
        LOG.info("查询周报信息开始,查询条件={}",weekPlanInfoQuery);
        User user = userService.getUser(request);
        return weekWorkService.getWeekPlanInfo(weekPlanInfoQuery,user);
    }

    @RequestMapping("/addWeekPlanInfo")
    public String addWeekPlanInfo(WeekPlanInfo weekPlanInfo,HttpServletRequest request){
        LOG.info("接收到添加周报请求{}",weekPlanInfo);
        User user = userService.getUser(request);
        return weekWorkService.addWeekPlanInfo(weekPlanInfo,user);
    }

    @RequestMapping("/addBackPlan")
    public String addBackPlan(BackPlan backPlan,HttpServletRequest request){
        LOG.info("接收到添加后续计划请求{}",backPlan);
        return weekWorkService.addBackPlan(backPlan);
    }

    @RequestMapping("/getBackPlan")
    @ResponseBody
    public PageBean<BackPlan> getBackPlan(BackPlanQuery backPlanQuery,HttpServletRequest request){
        LOG.info("接收到查询后续计划请求{}",backPlanQuery);
        return weekWorkService.getBackPlan(backPlanQuery);
    }

    /**
     * 将计划转换为周工作计划
     * @return
     */
    @RequestMapping("/backPlanToWeekPlan")
    public String backPlanToWeekPlan(BackPlan backPlan,HttpServletRequest request){
        LOG.info("接收到转换工作请求{}",backPlan);
        User user = userService.getUser(request);
        return weekWorkService.backPlanToWeekPlan(backPlan,user);
    }
}
