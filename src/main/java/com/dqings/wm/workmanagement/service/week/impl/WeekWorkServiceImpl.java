package com.dqings.wm.workmanagement.service.week.impl;

import com.dqings.wm.workmanagement.mapper.WeekWorkDao;
import com.dqings.wm.workmanagement.po.*;
import com.dqings.wm.workmanagement.service.week.WeekWorkService;
import com.dqings.wm.workmanagement.utils.IDUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther: dongqing
 * @date: 2019/9/4 16:30
 * @description:
 */
@Service
public class WeekWorkServiceImpl implements WeekWorkService {

    private static final Logger LOG = LoggerFactory.getLogger(WeekWorkServiceImpl.class);

    private static final String WORK_PREFIX="WORK";
    private static final String WEEK_PREFIX="WEEK";
    private static final String BACK_PREFIX="BACK";

    @Autowired
    private WeekWorkDao weekWorkDao;

    @Override
    public PageBean<WeekPlanInfo> getWeekPlanInfo(WeekPlanInfoQuery weekPlanInfoQuery, User user) {
        try {
            PageBean<WeekPlanInfo> pageBean = new PageBean<>();
            pageBean.setCurrentPage(weekPlanInfoQuery.getPage());
            pageBean.setPageSize(weekPlanInfoQuery.getRows());
            int start = (pageBean.getCurrentPage()-1)*pageBean.getPageSize();
            weekPlanInfoQuery.setPage(start);
            weekPlanInfoQuery.setUserId(user.getUserId());
            List<WeekPlanInfo> weekPlanInfoList = weekWorkDao.getWeekPlanInfoList(weekPlanInfoQuery);
            pageBean.setRows(weekPlanInfoList);
            int count = weekWorkDao.getWeekPlanInfoCount();
            pageBean.setTotal(count);
            return pageBean;
        }catch (Exception e){
            LOG.error("查询周报信息错误",e);
        }
        return null;
    }


    @Override
    public String addWeekPlanInfo(WeekPlanInfo weekPlanInfo, User user) {
        try {
            weekPlanInfo.setWorkIdPri(WORK_PREFIX+IDUtils.getID());
            weekPlanInfo.setWeekId(WEEK_PREFIX+IDUtils.getID());
            weekPlanInfo.setIsComplete("0");//1=完成，0=未完成
            weekPlanInfo.setUserId(user.getUserId());
            weekPlanInfo.setRealDay(weekPlanInfo.getRealDay()==null?0:weekPlanInfo.getRealDay());
            String planInfoSort = weekWorkDao.getWeekPlanInfoSort();
            int sort = planInfoSort==null?Integer.valueOf("0"):Integer.valueOf(planInfoSort);
            weekPlanInfo.setSort(sort);
            LOG.info("添加周报开始{}",weekPlanInfo);
            weekWorkDao.addWeekPlanInfo(weekPlanInfo);
            LOG.info("添加周报成功");
            return "success";
        }catch (Exception e){
            LOG.error("添加周报异常",e);
        }
        return null;
    }

    @Override
    public String addBackPlan(BackPlan backPlan) {
        try {
            backPlan.setID(BACK_PREFIX+IDUtils.getID());
            String backPlanSort = weekWorkDao.getBackPlanSort();
            int sort = backPlanSort==null?Integer.valueOf("0"):Integer.valueOf(backPlanSort);
            backPlan.setSort(sort);
            LOG.info("添加后续计划开始{}",backPlan);
            weekWorkDao.addBackPlan(backPlan);
            LOG.info("添加后续计划成功");
        }catch (Exception e){
            LOG.error("添加后续计划异常",e);
        }
        return null;
    }


    @Override
    public PageBean<BackPlan> getBackPlan(BackPlanQuery backPlanQuery) {
        try {
            PageBean<BackPlan> pageBean = new PageBean<>();
            pageBean.setCurrentPage(backPlanQuery.getPage());
            pageBean.setPageSize(backPlanQuery.getRows());
            int start = (pageBean.getCurrentPage()-1)*pageBean.getPageSize();
            backPlanQuery.setPage(start);
            List<BackPlan> backPlanList = weekWorkDao.getBackPlanList(backPlanQuery);
            pageBean.setRows(backPlanList);
            int backPlanCount = weekWorkDao.getBackPlanCount();
            pageBean.setTotal(backPlanCount);
            return pageBean;
        }catch (Exception e){
            LOG.error("查询后续计划信息失败",e);
        }
        return null;
    }


    @Override
    public String backPlanToWeekPlan(BackPlan backPlan, User user) {
        try {
            WeekPlanInfo weekPlanInfo = new WeekPlanInfo();
            weekPlanInfo.setWorkIdPri(WORK_PREFIX+IDUtils.getID());
            weekPlanInfo.setWeekId(backPlan.getWeekId());
            weekPlanInfo.setIsComplete("0");//1=完成，0=未完成
            weekPlanInfo.setUserId(user.getUserId());
            weekPlanInfo.setRealDay(weekPlanInfo.getRealDay()==null?0:weekPlanInfo.getRealDay());
            String planInfoSort = weekWorkDao.getWeekPlanInfoSort();
            int sort = planInfoSort==null?Integer.valueOf("0"):Integer.valueOf(planInfoSort);
            weekPlanInfo.setSort(sort);
            weekPlanInfo.setWorkDescribe(backPlan.getWorkDescirbe());
            LOG.info("转换周报开始{}",weekPlanInfo);
            weekWorkDao.addWeekPlanInfo(weekPlanInfo);
            LOG.info("转换周报成功");
            weekWorkDao.deleteBackPlanById(backPlan.getID());
            return "success";
        }catch (Exception e){
            LOG.error("后续计划转换为周报错误",e);
        }
        return null;
    }


}
