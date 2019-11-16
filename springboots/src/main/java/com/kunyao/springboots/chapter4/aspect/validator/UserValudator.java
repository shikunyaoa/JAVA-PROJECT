package com.kunyao.springboots.chapter4.aspect.validator;

import com.kunyao.springboots.chapter3.pojo.User;

public interface UserValudator {

    //检测用户对象是否为空
    public boolean validate(User user);
}
