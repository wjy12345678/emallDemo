package com.emall.service.Iservice;

import com.emall.common.ServerResponse;
import com.emall.pojo.User;

/**
 * Created by Administrator on 2017/11/29 0029.
 */
public interface UserService {

    public ServerResponse<User> login(String username,String password);
}
