package com.dqings.wm.workmanagement.service.user;

import com.dqings.wm.workmanagement.po.User;

public interface UserService {
    String doRegister(User user);
    User doLogin(User user);
}
