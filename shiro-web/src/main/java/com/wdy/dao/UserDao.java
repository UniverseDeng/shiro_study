package com.wdy.dao;

import com.wdy.vo.User;

import java.util.List;

/**
 * Created by wudengyu8f@foxmail.com on 2018/11/01
 */
public interface UserDao {
    User getUserByUserName(String userName);

    List<String> queryRolesByUserName(String userName);
}
