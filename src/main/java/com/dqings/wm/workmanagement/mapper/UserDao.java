package com.dqings.wm.workmanagement.mapper;

import com.dqings.wm.workmanagement.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDao {
    void saveUser(User user);
    User findUserByuserNameAndPassword(User user);
}
