package com.dqings.wm.workmanagement.po;

import lombok.Data;

@Data
public class BackPlanQuery extends PageBase {
    private String ID;
    private String weekId;
    private String workDescirbe;

}
