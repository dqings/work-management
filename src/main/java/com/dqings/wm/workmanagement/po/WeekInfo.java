package com.dqings.wm.workmanagement.po;

import lombok.Data;

import java.util.Date;

/**
 * @auther: dongqing
 * @date: 2019/9/4 16:23
 * @description:
 */
@Data
public class WeekInfo {
    private String ID;//主键
    private String weekId;//所属周报
    private Integer validWorkDay;
    private String completeness;
    private String weekStatus;
    private Date createTime;
}
