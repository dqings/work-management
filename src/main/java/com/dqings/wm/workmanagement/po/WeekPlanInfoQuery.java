package com.dqings.wm.workmanagement.po;

import lombok.Data;

@Data
public class WeekPlanInfoQuery extends PageBase {

    private String workIdPri;//主键
    private String userId;//所属用户
    private String weekId;//周报标识
    private String workDescribe;//工作描述
    private Integer planDay;//计划天数
    private Integer realDay;//真实天数
    private String isComplete;//是否完成

}
