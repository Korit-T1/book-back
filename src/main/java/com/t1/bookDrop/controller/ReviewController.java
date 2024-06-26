package com.t1.bookDrop.controller;

import com.t1.bookDrop.aop.annotation.ValidAspect;
import com.t1.bookDrop.dto.reqDto.FindReviewReqDto;
import com.t1.bookDrop.dto.reqDto.ReviewReqDto;
import com.t1.bookDrop.dto.respDto.ReviewRespDto;
import com.t1.bookDrop.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @ValidAspect
    @PostMapping("/review")
    public ResponseEntity<?> reviewSave(@Valid @RequestBody ReviewReqDto reviewReqDto, BindingResult bindingResult){
        reviewService.saveReview(reviewReqDto);
        return ResponseEntity.created(null).body(true);
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<ReviewRespDto>> findReviews(FindReviewReqDto findReviewReqDto){
        return ResponseEntity.ok(reviewService.getReview(findReviewReqDto));
    }

    @GetMapping("/reviews/count")
    public ResponseEntity<?> findReviewCount(FindReviewReqDto findReviewReqDto){
        return ResponseEntity.ok(reviewService.getReviewCount(findReviewReqDto));
    }

}
