package com.kunyao.springboots.chapter6.dao;

import com.kunyao.springboots.chapter6.pojo.User;

/**
 * @ClassName UserDao
 * @Description 用户接口
 * @Author kunyao
 * @Date $
 */
public interface UserDao {

    User getUser(Long id);

    int insertUser(User user);

}
