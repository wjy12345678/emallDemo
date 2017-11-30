package com.emall.service.Impl;

import com.emall.common.ServerResponse;
import com.emall.dao.UserMapper;
import com.emall.pojo.User;
import com.emall.service.Iservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/11/29 0029.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public ServerResponse<User> login(String username, String password) {
        return null;
    }
}
