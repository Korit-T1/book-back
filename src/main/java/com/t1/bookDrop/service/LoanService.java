package com.t1.bookDrop.service;

import com.t1.bookDrop.dto.reqDto.LoanReqDto;
import com.t1.bookDrop.repository.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoanService {

    @Autowired
    private BookMapper bookMapper;

    @Transactional(rollbackFor = Exception.class)
    public void saveLoan(LoanReqDto loanReqDto) {
        bookMapper.saveLoan(loanReqDto.toEntity());
    }
    @Transactional(rollbackFor = Exception.class)
    public void updateReturn(int loanId){
        bookMapper.updateReturnDate(loanId);
    }

}
