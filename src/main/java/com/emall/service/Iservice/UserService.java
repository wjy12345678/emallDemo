package com.emall.service.Iservice;

import com.emall.common.ServerResponse;
import com.emall.common.ServerResponse1;
import com.emall.pojo.User;

/**
 * Created by Administrator on 2017/11/29 0029.
 */
public interface UserService {

    public ServerResponse1<User> login(String username, String password);
    public ServerResponse1<String> checkIsUsername(String str,String type);
    public ServerResponse1<String> registry(User user);

}
