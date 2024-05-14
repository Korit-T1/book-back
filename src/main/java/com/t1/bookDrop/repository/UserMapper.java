package com.t1.bookDrop.repository;

import com.t1.bookDrop.entity.AdminUser;
import com.t1.bookDrop.entity.OAuth2;
import com.t1.bookDrop.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    public User userCheckByUsername(String username);
    public int saveUser(User user);
    public User userCheckByOAuth2name(String oAuth2name);
    public int saveOAuth2(OAuth2 oAuth2);
    public int modifyPassword(User user);
    // userCheck, findUserByUsername 확인 필요
    public User findUserByUserId(int userId);
    public User findUser(
            @Param("username") String username,
            @Param("name") String name,
            @Param("email") String email,
            @Param("phone") String phone
    );
}
