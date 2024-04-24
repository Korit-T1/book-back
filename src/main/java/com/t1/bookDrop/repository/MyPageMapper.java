package com.t1.bookDrop.repository;

import com.t1.bookDrop.entity.Loan;
import com.t1.bookDrop.entity.Wish;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MyPageMapper {
    public List<Loan> getLoanHistory(int userid);
    public List<Wish> getWishList(int userid);
    public int updateProfileImage(@Param("userid") int userid, @Param("url") String url);
}
