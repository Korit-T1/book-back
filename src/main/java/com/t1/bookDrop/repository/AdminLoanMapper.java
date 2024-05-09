package com.t1.bookDrop.repository;

import com.t1.bookDrop.entity.AdminLoan;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminLoanMapper {
    public List<AdminLoan> getAdminLoan();
    public List<AdminLoan> getAdminReturn();
    public int updateReturnOrNot(int loanId);
    public List<AdminLoan> getAdminOverdue();
}
