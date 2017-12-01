package com.emall.service.Impl;

import com.emall.common.Const;
import com.emall.common.ServerResponse;
import com.emall.common.ServerResponse1;
import com.emall.dao.UserDao;
import com.emall.pojo.User;
import com.emall.service.Iservice.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/11/29 0029.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Transactional
    @Override
    public ServerResponse1<User> login(String username, String password) {
        //验证用户名是否存在
        int result = 0;
        try {
            result = userDao.checkUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (result == 0){
            return ServerResponse1.createError("用户名不存在！");
        }
        //对密码进行md5加密处理
        //验证登录信息
        User user = null;
        try {
            user = userDao.login(username,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (user == null){
            return ServerResponse1.createError("密码错误");
        }
        //登录成功，将密码质空
        user.setPassword(StringUtils.EMPTY);
        return ServerResponse1.createSuccess("登录成功",user);
    }

    @Transactional
    @Override
    public ServerResponse1<String> checkIsUsername(String str, String type) {

        if (StringUtils.isNotBlank(type)){
           /* try {
                int col = userDao.checkIsUsername(str,type);
                if (col == 0){
                    return ServerResponse1.createSuccess("校验成功");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }*/
            if (Const.validType.USERNAME.equals(type)){
                try {
                    int col = userDao.checkUsername(str);
                    if (col > 0){
                        return ServerResponse1.createError("用户名已存在");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (Const.validType.EMAIL.equals(type)){
                try {
                    int col = userDao.checkEmail(str);
                    if (col > 0){
                        return ServerResponse1.createError("邮箱已存在");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }else {
            return ServerResponse1.createError("参数类型错误");
        }

        return ServerResponse1.createSuccess("验证成功");
    }

    @Transactional
    @Override
    public ServerResponse1<String> registry(User user) {

        return null;
    }
}
