package com.jeeqb.zblog.mapper;

import com.jeeqb.zblog.vo.User;
import com.jeeqb.zblog.vo.UserInfo;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * FILE: com.jeeqb.zblog.mapper.UserMapper.java
 */
@Mapper
public interface UserMapper {
    /**
     * 获取用户凭证
     * @param username 账号
     * @return
     */
    User getUser(@Param("username") String username);

    /**
     * 获取所有的用户
     * @return
     */
    List<User> allUser();

    UserInfo getUserInfo();

    void updateAvatar(@Param("url") String url, @Param("username") String username);

    void updatePassword(User user);

    void updateUserInfo(UserInfo userInfo);
}
