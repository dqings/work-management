package com.dqings.wm.workmanagement.mapper;

import com.dqings.wm.workmanagement.po.DayWork;
import com.dqings.wm.workmanagement.po.DayWorkQuery;
import com.dqings.wm.workmanagement.po.WorkRemark;
import com.dqings.wm.workmanagement.po.WorkRemarkQuery;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @auther: dongqing
 * @date: 2019/9/4 15:57
 * @description:
 */
@Repository
@Mapper
public interface DayWorkDao {

    List<DayWork> getWorkContent(DayWorkQuery dayWorkQuery);
    int getWorkCount();
    void addDayWork(DayWork dayWork);
    List<WorkRemark> getWorkRemark(WorkRemarkQuery workRemarkQuery);
    void addWorkRemark(WorkRemark workRemark);
    int getRemarkCount();
    String getRemarkSort();
}
