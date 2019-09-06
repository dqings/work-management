package com.dqings.wm.workmanagement.service.user;

import com.dqings.wm.workmanagement.po.User;

import javax.servlet.http.HttpServletRequest;

public interface UserService {
    String doRegister(User user);
    User doLogin(User user);
    User getUser(HttpServletRequest request);
}
