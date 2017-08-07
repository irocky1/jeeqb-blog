package com.jeeqb.zblog.service;


import com.jeeqb.zblog.vo.User;
import com.jeeqb.zblog.vo.UserInfo;

public interface UserService {


    User loadUserByUsername(String username);

    UserInfo getUserInfo();

    void updateAvatar(String url, String username);

    void updatePassword(User user);

    void updateUserInfo(UserInfo userInfo);

    User getCurrentUser();
}
