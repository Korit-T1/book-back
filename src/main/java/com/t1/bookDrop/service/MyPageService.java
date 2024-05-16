package com.t1.bookDrop.service;

import com.t1.bookDrop.dto.reqDto.MostLoanedRespDto;
import com.t1.bookDrop.dto.reqDto.MyBookReqDto;
import com.t1.bookDrop.dto.reqDto.UpdateProfileImageReqDto;
import com.t1.bookDrop.dto.respDto.mypage.LoanHistoryRespDto;
import com.t1.bookDrop.dto.respDto.mypage.SummaryRespDto;
import com.t1.bookDrop.dto.respDto.mypage.WishListRespDto;
import com.t1.bookDrop.entity.FavoriteCategory;
import com.t1.bookDrop.entity.Loan;
import com.t1.bookDrop.entity.MostLoanedBook;
import com.t1.bookDrop.entity.Wish;
import com.t1.bookDrop.repository.MyPageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MyPageService {

    @Autowired
    private MyPageMapper myPageMapper;

    // 마이페이지 메인
    public SummaryRespDto getSummaryInfo(int userid) {
        FavoriteCategory favoriteCategory = myPageMapper.getFavoriteInfo(userid);
        MostLoanedBook mostLoanedBook = myPageMapper.getMostLoanedInfo(userid);

        return SummaryRespDto.builder()
                .overdue(myPageMapper.getOverdueCount(userid))
                .reading(myPageMapper.getReadingCount(userid))
                .returned(myPageMapper.getReturnedCount(userid))
                .favoriteCategoryName(favoriteCategory.getName())
                .favoriteCategoryCount(favoriteCategory.getCount())
                .build();
    }

    public MostLoanedBook getMostLoaned(int userid) {
        return myPageMapper.getMostLoanedInfo(userid);
    }



    // 대출 중인 도서
    public List<LoanHistoryRespDto> getReadingBooks(MyBookReqDto myBookReqDto) {
        int index = (myBookReqDto.getPage() - 1) * 6;
        List<Loan> loans = myPageMapper.getReadingBooks(index, myBookReqDto.getUserid(), myBookReqDto.getFilter());

        return loans.stream().map(Loan::toRespDto).collect(Collectors.toList());
    }
    public int getReadingBooksCount(MyBookReqDto myBookReqDto) {
        return myPageMapper.getReadingBooksCount(myBookReqDto.getUserid(), myBookReqDto.getFilter());
    }

    // 반납한 도서
    public List<LoanHistoryRespDto> getReturnedBooks(MyBookReqDto myBookReqDto) {
        int index = (myBookReqDto.getPage() - 1) * 6;
        List<Loan> loans = myPageMapper.getReturnedBooks(index, myBookReqDto.getUserid(), myBookReqDto.getFilter());

        return loans.stream().map(Loan::toRespDto).collect(Collectors.toList());
    }
    public int getReturnedBooksCount(MyBookReqDto myBookReqDto) {
        return myPageMapper.getReturnedBooksCount(myBookReqDto.getUserid(), myBookReqDto.getFilter());
    }

    // 위시리스트
    public List<WishListRespDto> getWishData(MyBookReqDto myBookReqDto) {
        int index = (myBookReqDto.getPage() - 1) * 6;

        List<Wish> wishList = myPageMapper.getWishList(
                index,
                myBookReqDto.getUserid(),
                myBookReqDto.getFilter()
        );

        return wishList.stream().map(Wish::toRespDto).collect(Collectors.toList());
    }
    public int getWishCount(MyBookReqDto myBookReqDto) {
        return myPageMapper.getWishCount(
                myBookReqDto.getUserid(),
                myBookReqDto.getFilter()
        );
    }

    // 프사 업뎃
    public int updateProfileImage(UpdateProfileImageReqDto updateProfileImageReqDto) {
        System.out.println("service: "  + updateProfileImageReqDto);
        return myPageMapper.updateProfileImage(updateProfileImageReqDto.getUserid(), updateProfileImageReqDto.getImageUrl());
    }
}
