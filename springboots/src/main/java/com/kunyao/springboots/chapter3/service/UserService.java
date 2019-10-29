package com.kunyao.springboots.chapter3.service;

import com.kunyao.springboots.chapter3.pojo.User;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserService
 * @Description 业务类
 * @Author kunyao
 * @Date $
 */
@Service
public class UserService {

    public void printUser(User user){
        System.out.println("编号：" + user.getId());
        System.out.println("用户名称：" + user.getUsername());
        System.out.println("备注：" + user.getNote());
    }
}
