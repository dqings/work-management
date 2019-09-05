package com.dqings.wm.workmanagement.controller.day;

import com.dqings.wm.workmanagement.enums.ConstantEnum;
import com.dqings.wm.workmanagement.po.DayWork;
import com.dqings.wm.workmanagement.po.DayWorkQuery;
import com.dqings.wm.workmanagement.po.PageBean;
import com.dqings.wm.workmanagement.po.User;
import com.dqings.wm.workmanagement.service.day.DayWorkService;
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

    @RequestMapping("/work")
    public String work(){
        return "/day/dayWork";
    }

    @RequestMapping("/backPlan")
    public String backPlan(){
        return "/day/backPlan";
    }

    @RequestMapping("/getWorkContent")
    @ResponseBody
    public PageBean<DayWork> getWorkContent(DayWorkQuery dayWorkQuery){
        LOG.info("查询日报信息开始,查询条件={}",dayWorkQuery);
        return dayWorkService.getWorkContent(dayWorkQuery);
    }

    @RequestMapping("/addDayWork")
    public String addDayWork(DayWork dayWork, HttpServletRequest request){
        LOG.info("添加日报开始,参数={}",dayWork);
        User user = (User) request.getSession().getAttribute(ConstantEnum.USER.getCode());
        return dayWorkService.addDayWork(dayWork,user);
    }
}
