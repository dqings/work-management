package com.dqings.wm.workmanagement.service.week;

import com.dqings.wm.workmanagement.po.*;

/**
 * @auther: dongqing
 * @date: 2019/9/4 16:29
 * @description:
 */
public interface WeekWorkService {

    PageBean<WeekPlanInfo>  getWeekPlanInfo(WeekPlanInfoQuery weekPlanInfoQuery, User user);
    String addWeekPlanInfo(WeekPlanInfo weekPlanInfo,User user);
    String addBackPlan(BackPlan backPlan);
    PageBean<BackPlan> getBackPlan(BackPlanQuery backPlanQuery);
    String backPlanToWeekPlan(BackPlan backPlan,User user);
}
