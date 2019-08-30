package com.dqings.wm.workmanagement.po;

import lombok.Data;

/**
 * @auther: dongqing
 * @date: 2019/8/30 17:36
 * @description:
 */
@Data
public class User {
    private Integer ID;//主键
    private String userId;//用户ID
    private String userName;//用户名
    private String password;//密码
    private String name;//姓名
    private String sex;//性别
    private String describe;//描述
    private String email;//邮箱
    private String mobile;//手机号
}
