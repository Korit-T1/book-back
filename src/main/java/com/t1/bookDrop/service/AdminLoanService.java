package com.t1.bookDrop.service;

import com.t1.bookDrop.dto.respDto.AdminLoanRespDto;
import com.t1.bookDrop.entity.AdminLoan;
import com.t1.bookDrop.repository.AdminLoanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminLoanService {
    @Autowired
    AdminLoanMapper adminLoanMapper;


    public List<AdminLoanRespDto> getLoans() {
        return adminLoanMapper.getAdminLoan().stream().map(AdminLoan::toAdminLoanRespDto).collect(Collectors.toList());
    }
    public List<AdminLoanRespDto> gteReturns() {
        return adminLoanMapper.getAdminReturn().stream().map(AdminLoan::toAdminLoanRespDto).collect(Collectors.toList());
    }
    public void updateReturn(int loanId){
        adminLoanMapper.updateReturnOrNot(loanId);
    }
    public List<AdminLoanRespDto> getOverdues() {
        return adminLoanMapper.getAdminOverdue().stream().map(AdminLoan::toAdminLoanRespDto).collect(Collectors.toList());
    }
}
