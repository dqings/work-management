package com.dqings.wm.workmanagement.po;

import lombok.Data;

import java.util.Date;

/**
 * @auther: dongqing
 * @date: 2019/9/5 13:45
 * @description:
 */
@Data
public class DayWorkQuery extends PageBase{
    private String dayId;//主键
    private String userId;//用户ID
    private Date createTime;//创建时间
    private String workEnvironment;//工作环境
    private String workContent;//工作内容
}
