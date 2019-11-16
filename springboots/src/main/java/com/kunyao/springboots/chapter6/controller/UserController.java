package com.kunyao.springboots.chapter6.controller;

import com.kunyao.springboots.chapter6.pojo.User;
import com.kunyao.springboots.chapter6.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName UserController
 * @Description 用户控制器
 * @Author kunyao
 * @Date $
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService = null;

    @RequestMapping("/getUser")
    @ResponseBody
    public User getUser(Long id){
        return userService.getUser(id);
    }

    @RequestMapping("/insertUser")
    @ResponseBody
    public Map<String, Object> insertUser(String userName, String note){
        User user = new User();
        user.setUsername(userName);
        user.setNote(note);
        //结果会回填主键，返回插入条数
        int update = userService.insertUser(user);
        Map<String, Object> result = new HashMap<>();
        result.put("success", update ==  1);
        result.put("user", user);
        return result;
    }
}
