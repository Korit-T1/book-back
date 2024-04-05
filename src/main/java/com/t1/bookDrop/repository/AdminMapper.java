package com.t1.bookDrop.repository;

import com.t1.bookDrop.entity.Admin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {
    public Admin adminCheckByUsername(String username);
}
