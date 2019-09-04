package com.dqings.wm.workmanagement.po;

import lombok.Data;

/**
 * @auther: dongqing
 * @date: 2019/9/4 16:18
 * @description:
 */
@Data
public class WeekPlanInfo {
    private String workIdPri;//主键
    private String userId;//所属用户
    private String weekId;//周报标识
    private String workDescribe;//工作描述
    private Integer planDay;//计划天数
    private Integer realDay;//真实天数
    private String isComplete;//是否完成
    private Integer sort;//排序
}
