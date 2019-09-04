package com.dqings.wm.workmanagement.po;

import lombok.Data;

/**
 * @auther: dongqing
 * @date: 2019/9/4 16:07
 * @description:
 */
@Data
public class WorkRemark {
    private String remarkId;//主键
    private String userId;//所属用户
    private String title;//标题
    private String contentDescribe;//内容描述
    private Integer sort;//排序
}
