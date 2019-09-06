package com.dqings.wm.workmanagement.service.day.impl;

import com.dqings.wm.workmanagement.mapper.DayWorkDao;
import com.dqings.wm.workmanagement.po.*;
import com.dqings.wm.workmanagement.service.day.DayWorkService;
import com.dqings.wm.workmanagement.utils.IDUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @auther: dongqing
 * @date: 2019/9/4 15:57
 * @description:
 */
@Service
public class DayWorkServiceImpl implements DayWorkService {

    private static final Logger LOG = LoggerFactory.getLogger(DayWorkServiceImpl.class);

    private static final String DAY_PREFIX="DAY";
    private static final String REMARK_PREFIX="REMARK";

    @Autowired
    private DayWorkDao dayWorkDao;

    @Override
    public PageBean<DayWork> getWorkContent(DayWorkQuery dayWorkQuery,User user) {
        try {
            PageBean<DayWork> pageBean = new PageBean<>();
            pageBean.setCurrentPage(dayWorkQuery.getPage());
            pageBean.setPageSize(dayWorkQuery.getRows());
            int start = (pageBean.getCurrentPage()-1)*pageBean.getPageSize();
            dayWorkQuery.setPage(start);
            dayWorkQuery.setUserId(user.getUserId());
            List<DayWork> dayWorkList = dayWorkDao.getWorkContent(dayWorkQuery);
            pageBean.setRows(dayWorkList);
            int workCount = dayWorkDao.getWorkCount();
            pageBean.setTotal(workCount);
            return pageBean;
        }catch (Exception e){
            LOG.error("查询日报信息异常",e);
        }
        return null;
    }

    @Override
    public String addDayWork(DayWork dayWork, User user) {
        try {
            dayWork.setDayId(DAY_PREFIX+ IDUtils.getID());
            dayWork.setCreateTime(new Date());
            dayWork.setUserId(user.getUserId());
            dayWorkDao.addDayWork(dayWork);
            return "success";
        }catch (Exception e){
            LOG.error("添加日报异常",e);
        }
        return null;
    }

    @Override
    public PageBean<WorkRemark> getWorkRemark(WorkRemarkQuery workRemarkQuery,User user) {
        try {
            PageBean<WorkRemark> pageBean = new PageBean<>();
            pageBean.setCurrentPage(workRemarkQuery.getPage());
            pageBean.setPageSize(workRemarkQuery.getRows());
            int start = (pageBean.getCurrentPage()-1)*pageBean.getPageSize();
            workRemarkQuery.setPage(start);
            workRemarkQuery.setUserId(user.getUserId());
            List<WorkRemark> workRemarkList = dayWorkDao.getWorkRemark(workRemarkQuery);
            pageBean.setRows(workRemarkList);
            int remarkCount = dayWorkDao.getRemarkCount();
            pageBean.setTotal(remarkCount);
            return pageBean;
        }catch (Exception e){
            LOG.error("查询备忘录异常",e);
        }
        return null;
    }

    @Override
    public String addWorkRemark(WorkRemark workRemark, User user) {
        try {
            workRemark.setRemarkId(REMARK_PREFIX+IDUtils.getID());
            workRemark.setUserId(user.getUserId());
            String remarkSort = dayWorkDao.getRemarkSort();
            remarkSort = remarkSort==null?"0":remarkSort;
            workRemark.setSort(Integer.valueOf(remarkSort)+1);
            dayWorkDao.addWorkRemark(workRemark);
            return "success";
        }catch (Exception e){
            LOG.error("添加备忘录异常",e);
        }
        return null;
    }

}
