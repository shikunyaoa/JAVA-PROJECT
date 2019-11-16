package com.kunyao.springboots.chapter4.aspect.validator.impl;

import com.kunyao.springboots.chapter3.pojo.User;
import com.kunyao.springboots.chapter4.aspect.validator.UserValudator;

/**
 * @ClassName UserValidatorImpl
 * @Description UserValidator的实现类
 * @Author kunyao
 * @Date $
 */
public class UserValidatorImpl implements UserValudator {

    @Override
    public boolean validate(User user) {
        System.out.println(UserValudator.class.getSimpleName());
        return user != null;
    }
}
