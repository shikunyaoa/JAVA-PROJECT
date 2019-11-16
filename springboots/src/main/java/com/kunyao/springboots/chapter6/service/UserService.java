package com.kunyao.springboots.chapter6.service;

import com.kunyao.springboots.chapter6.pojo.User;

public interface UserService {

    //获取用户信息
    public User getUser(Long id);

    //新增用户
    public int insertUser(User user);
}
