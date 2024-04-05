package com.t1.bookdrop.service;

import com.t1.bookdrop.entity.Loan;
import com.t1.bookdrop.repository.MyPageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MypageService {

    @Autowired
    private MyPageMapper myPageMapper;

    public List<Loan> getLoanData(int userId) {
        List<Loan> loans = myPageMapper.getLoanHistory(userId);

        return loans;
    }

}
