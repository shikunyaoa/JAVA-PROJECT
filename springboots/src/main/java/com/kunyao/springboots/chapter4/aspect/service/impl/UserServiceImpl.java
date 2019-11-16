package com.kunyao.springboots.chapter4.aspect.service.impl;

import com.kunyao.springboots.chapter3.pojo.User;
import com.kunyao.springboots.chapter4.aspect.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserServiceImpl
 * @Description 用户服务接口实现类
 * @Author kunyao
 * @Date $
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public void printUser(User user) {
        if(user == null){
            throw new RuntimeException("用户参数不能为空");
        }
        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getNote());
        
    }
}
