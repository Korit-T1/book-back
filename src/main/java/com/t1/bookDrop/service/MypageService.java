package com.t1.bookDrop.service;

import com.t1.bookDrop.dto.reqDto.UpdateProfileImageReqDto;
import com.t1.bookDrop.dto.respDto.mypage.LoanHistoryRespDto;
import com.t1.bookDrop.dto.respDto.mypage.WishListRespDto;
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

    public List<LoanHistoryRespDto> getLoanData(int userid) {
        List<Loan> loans = myPageMapper.getLoanHistory(userid);

        return loans.stream().map(Loan::toRespDto).collect(Collectors.toList());
    }

    public List<WishListRespDto> getWishData(int userid) {
        List<Wish> wishList = myPageMapper.getWishList(userid);

        return wishList.stream().map(Wish::toRespDto).collect(Collectors.toList());
    }

    public int updateProfileImage(UpdateProfileImageReqDto updateProfileImageReqDto) {
        System.out.println("service: "  + updateProfileImageReqDto);
        return myPageMapper.updateProfileImage(updateProfileImageReqDto.getUserid(), updateProfileImageReqDto.getImageUrl());
    }
}
