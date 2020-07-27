package com.tove582700730.service;

import com.tove582700730.pojo.Users;
import com.tove582700730.util.ResultVo;

import javax.servlet.http.HttpSession;

public interface UserService {

    /**
     * 注册
     * @param users
     * @return
     */
    ResultVo regist(Users users);

    /**
     * 登录
     * @param users
     * @return
     */
    ResultVo login(Users users, HttpSession session);
}
