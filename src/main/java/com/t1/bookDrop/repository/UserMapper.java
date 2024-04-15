package com.t1.bookDrop.repository;

import com.t1.bookDrop.entity.OAuth2;
import com.t1.bookDrop.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    public User userCheckByUsername(String username);
    public int saveUser(User user);
    public User userCheckByOAuth2name(String oAuth2name);
    public int saveOAuth2(OAuth2 oAuth2);
    public User findUserByUsername(String username);
    public int modifyPassword(User user);
    // userCheck, findUserByUsername 확인 필요
}
