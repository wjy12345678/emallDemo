package com.emall.controller;

import com.emall.common.ServerResponse;
import com.emall.pojo.User;
import com.emall.service.Iservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2017/11/29 0029.
 */
@Controller
@RequestMapping("/user/")
public class UserAction {

    @Autowired
    private UserService userService;

    public ServerResponse<User> login(String username,String password,HttpSession session){
        return null;
    }
}
