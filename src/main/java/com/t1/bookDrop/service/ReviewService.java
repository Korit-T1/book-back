package com.t1.bookDrop.service;

import com.t1.bookDrop.dto.reqDto.ReviewReqDto;
import com.t1.bookDrop.dto.respDto.ReviewRespDto;
import com.t1.bookDrop.entity.Review;
import com.t1.bookDrop.repository.ReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {

    @Autowired
    private ReviewMapper reviewMapper;

    @Transactional(rollbackFor = Exception.class)
    public void saveReview(ReviewReqDto reviewReqDto)    {
        reviewMapper.saveReview(reviewReqDto.toEntity());
    }

    public List<ReviewRespDto> getReview(int bookId){
        return reviewMapper.findReviewsAllByBookId(bookId).stream().map(Review::toDto).collect(Collectors.toList());
    }
}
