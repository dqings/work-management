package com.dqings.wm.workmanagement.service.day;

import com.dqings.wm.workmanagement.po.DayWork;
import com.dqings.wm.workmanagement.po.DayWorkQuery;
import com.dqings.wm.workmanagement.po.PageBean;
import com.dqings.wm.workmanagement.po.User;

/**
 * @auther: dongqing
 * @date: 2019/9/4 15:56
 * @description:
 */
public interface DayWorkService {
    PageBean<DayWork> getWorkContent(DayWorkQuery dayWorkQuery);
    String addDayWork(DayWork dayWork, User user);
}
