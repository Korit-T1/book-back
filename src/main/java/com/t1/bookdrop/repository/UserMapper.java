package com.t1.bookdrop.repository;

import com.t1.bookdrop.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    public User userCheckByUsername(String username);
    public int saveUser(User user);
}
