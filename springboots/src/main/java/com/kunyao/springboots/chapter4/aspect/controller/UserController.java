package com.kunyao.springboots.chapter4.aspect.controller;

import com.kunyao.springboots.chapter3.pojo.User;
import com.kunyao.springboots.chapter4.aspect.service.UserService;
import com.kunyao.springboots.chapter4.aspect.validator.UserValudator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName UserController
 * @Description 用户控制器
 * @Author kunyao
 * @Date $
 */

@Controller
public class UserController {

    @Autowired
    private UserService userService = null;

    @RequestMapping("/print")
    @ResponseBody
    public User printUser(Long id, String username, String note){

        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setNote(note);

        //强制转换
        UserValudator userValudator = (UserValudator)userService;
        //验证用户是否为空
        if(userValudator.validate(user)){
            userService.printUser(user);
        }
        return user;
    }
}
