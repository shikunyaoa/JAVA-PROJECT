package com.kunyao.springboots.chapter6.service.impl;

import com.kunyao.springboots.chapter6.dao.UserDao;
import com.kunyao.springboots.chapter6.pojo.User;
import com.kunyao.springboots.chapter6.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName UserServiceImpl
 * @Description 用户服务类
 * @Author kunyao
 * @Date $
 */
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDao userDao = null;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, timeout = 1)
    public User getUser(Long id) {
        return userDao.getUser(id);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, timeout = 1)
    public int insertUser(User user) {
        return userDao.insertUser(user);
    }
}
