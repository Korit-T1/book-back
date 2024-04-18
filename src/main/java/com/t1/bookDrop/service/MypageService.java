package com.t1.bookDrop.service;

import com.t1.bookDrop.dto.respDto.mypage.LoanHistoryRespDto;
import com.t1.bookDrop.entity.Book;
import com.t1.bookDrop.entity.Loan;
import com.t1.bookDrop.entity.Wish;
import com.t1.bookDrop.repository.MyPageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MypageService {

    @Autowired
    private MyPageMapper myPageMapper;

    public List<LoanHistoryRespDto> getLoanData(String username) {
        List<Loan> loan = myPageMapper.getLoanHistory(username);

//        return loan.stream().map(Loan::toLoanHistoryRespDto).collect(Collectors.toList());
        return null;
    }


    public List<Wish> getWishData(int userid) {
        List<Wish> wishList = myPageMapper.getWishList(userid);

        return wishList;
    }

}
