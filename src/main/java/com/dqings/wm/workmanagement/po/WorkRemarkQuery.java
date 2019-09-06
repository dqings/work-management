package com.dqings.wm.workmanagement.po;

import lombok.Data;

/**
 * @auther: dongqing
 * @date: 2019/9/6 11:16
 * @description:
 */
@Data
public class WorkRemarkQuery extends PageBase {
    private String remarkId;//主键
    private String userId;//所属用户
    private String title;//标题
    private String contentDescribe;//内容描述
    private Integer sort;//排序
}
