package com.dqings.wm.workmanagement.controller.day;

import com.dqings.wm.workmanagement.enums.ConstantEnum;
import com.dqings.wm.workmanagement.po.*;
import com.dqings.wm.workmanagement.service.day.DayWorkService;
import com.dqings.wm.workmanagement.service.user.UserService;
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
@RequestMapping("/day")
public class DayWorkController {

    private static final Logger LOG = LoggerFactory.getLogger(DayWorkController.class);

    @Autowired
    private DayWorkService dayWorkService;

    @Autowired
    private UserService userService;

    @RequestMapping("/work")
    public String work(){
        return "/day/dayWork";
    }

    @RequestMapping("/workRemark")
    public String backPlan(){
        return "day/workRemark";
    }

    @RequestMapping("/getWorkContent")
    @ResponseBody
    public PageBean<DayWork> getWorkContent(DayWorkQuery dayWorkQuery,HttpServletRequest request){
        LOG.info("查询日报信息开始,查询条件={}",dayWorkQuery);
        User user = userService.getUser(request);
        return dayWorkService.getWorkContent(dayWorkQuery,user);
    }

    @RequestMapping("/addDayWork")
    public String addDayWork(DayWork dayWork, HttpServletRequest request){
        LOG.info("添加日报开始,参数={}",dayWork);
        User user = userService.getUser(request);
        return dayWorkService.addDayWork(dayWork,user);
    }

    @RequestMapping("/getWorkRemark")
    @ResponseBody
    public PageBean<WorkRemark> getWorkRemark(HttpServletRequest request,WorkRemarkQuery workRemarkQuery){
        LOG.info("查询备忘录开始,查询条件={}",workRemarkQuery);
        User user = userService.getUser(request);
        return dayWorkService.getWorkRemark(workRemarkQuery,user);
    }

    @RequestMapping("/addWorkRemark")
    public String addWorkRemark(WorkRemark workRemark,HttpServletRequest request){
        LOG.info("添加备忘录开始{}",workRemark);
        User user = userService.getUser(request);
        return dayWorkService.addWorkRemark(workRemark,user);
    }
}
