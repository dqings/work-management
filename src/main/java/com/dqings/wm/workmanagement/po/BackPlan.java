package com.dqings.wm.workmanagement.po;

import lombok.Data;

/**
 * @auther: dongqing
 * @date: 2019/9/4 16:26
 * @description:
 */
@Data
public class BackPlan {
    private String ID;
    private String weekId;
    private String workDescirbe;
    private Integer sort;
}
