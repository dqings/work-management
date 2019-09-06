package com.dqings.wm.workmanagement.service.user.impl;

import com.dqings.wm.workmanagement.enums.CodeEnum;
import com.dqings.wm.workmanagement.enums.ConstantEnum;
import com.dqings.wm.workmanagement.mapper.UserDao;
import com.dqings.wm.workmanagement.po.User;
import com.dqings.wm.workmanagement.service.user.UserService;
import com.dqings.wm.workmanagement.utils.IDUtils;
import com.dqings.wm.workmanagement.utils.SequenceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);
    private final String IDPREFIX="USER";

    @Autowired
    private UserDao userDao;

    @Override
    public String doRegister(User user) {
        try {
            //生成主键
            user.setID(SequenceUtil.nextId());
            //生成唯一标识
            user.setUserId(IDPREFIX+ IDUtils.getID());
            userDao.saveUser(user);
            return CodeEnum.SUCCESS.getCode();
        }catch (Exception e){
            LOG.error("注册用户异常",e);
        }
        return CodeEnum.ERROR.getCode();
    }


    @Override
    public User doLogin(User user) {
        try {
            return userDao.findUserByuserNameAndPassword(user);
        }catch (Exception e){
            LOG.error("登录异常",e);
        }
        return null;
    }

    @Override
    public User getUser(HttpServletRequest request) {
        return (User) request.getSession().getAttribute(ConstantEnum.USER.getCode());
    }
}
