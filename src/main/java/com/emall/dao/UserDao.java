package com.emall.dao;

import com.emall.common.ServerResponse1;
import com.emall.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2017/11/30 0030.
 */
public interface UserDao {
    public int checkUsername(String username) throws Exception;

    User login(@Param("username") String username,@Param("password") String password) throws Exception;
    public int checkIsUsername(@Param("str") String str, @Param("type") String type) throws Exception;

    public int checkEmail(String email) throws Exception;
    public int registry(User user) throws Exception;
}
