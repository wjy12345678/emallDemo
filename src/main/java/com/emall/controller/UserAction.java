package com.emall.controller;

import com.emall.common.Const;
import com.emall.common.ServerResponse;
import com.emall.common.ServerResponse1;
import com.emall.pojo.User;
import com.emall.service.Iservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2017/11/29 0029.
 */
@Controller
@RequestMapping("user")
public class UserAction {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "login.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse1<User> login(String username,String password,HttpSession session) {
        ServerResponse1<User> userServerResponse1 = userService.login(username, password);
        if (userServerResponse1.isSuccess()) {
            session.setAttribute(Const.CURRENT_USER, userServerResponse1.getData());
        }
        return userServerResponse1;
    }

    @RequestMapping(value = "logout.do",method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse1<String> loginOut(HttpSession session){

        session.removeAttribute(Const.CURRENT_USER);
        return ServerResponse1.createSuccess("退出成功");
    }
    @RequestMapping(value = "check_valid.do",method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse1<String> checkIsUsername(String str,String type){
        return userService.checkIsUsername(str,type);
    }

    @RequestMapping(value = "register.do",method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse1<String> registry(User user){
        return null;
    }
}
