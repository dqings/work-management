package com.dqings.wm.workmanagement.service.day;

import com.dqings.wm.workmanagement.po.*;

/**
 * @auther: dongqing
 * @date: 2019/9/4 15:56
 * @description:
 */
public interface DayWorkService {
    PageBean<DayWork> getWorkContent(DayWorkQuery dayWorkQuery,User user);
    String addDayWork(DayWork dayWork, User user);
    PageBean<WorkRemark> getWorkRemark(WorkRemarkQuery workRemarkQuery,User user);
    String addWorkRemark(WorkRemark workRemark,User user);
}
