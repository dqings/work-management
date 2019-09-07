package com.dqings.wm.workmanagement.mapper;

import com.dqings.wm.workmanagement.po.BackPlan;
import com.dqings.wm.workmanagement.po.BackPlanQuery;
import com.dqings.wm.workmanagement.po.WeekPlanInfo;
import com.dqings.wm.workmanagement.po.WeekPlanInfoQuery;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @auther: dongqing
 * @date: 2019/9/4 16:30
 * @description:
 */
@Repository
@Mapper
public interface WeekWorkDao {
    List<WeekPlanInfo> getWeekPlanInfoList(WeekPlanInfoQuery weekPlanInfoQuery);
    int getWeekPlanInfoCount();
    String getWeekPlanInfoSort();
    void addWeekPlanInfo(WeekPlanInfo weekPlanInfo);
    String getBackPlanSort();
    void addBackPlan(BackPlan backPlan);
    List<BackPlan> getBackPlanList(BackPlanQuery backPlanQuery);
    int getBackPlanCount();
    void deleteBackPlanById(String id);

}
