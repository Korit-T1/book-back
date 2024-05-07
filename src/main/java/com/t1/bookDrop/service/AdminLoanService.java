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

}
