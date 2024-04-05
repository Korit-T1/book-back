package com.t1.bookdrop.repository;

import com.t1.bookdrop.entity.Loan;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MyPageMapper {
    public List<Loan> getLoanHistory(int userid);
}
