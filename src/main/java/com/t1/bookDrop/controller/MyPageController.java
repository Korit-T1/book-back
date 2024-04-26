package com.t1.bookDrop.controller;

import com.t1.bookDrop.dto.reqDto.MyBookReqDto;
import com.t1.bookDrop.dto.reqDto.UpdateProfileImageReqDto;
import com.t1.bookDrop.service.MyPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/mypage")
@RestController
public class MyPageController {

    @Autowired
    private MyPageService mypageService;

    @GetMapping("/reading")
    public ResponseEntity<?> getReadingBooks(MyBookReqDto myBookReqDto) {
        return ResponseEntity.ok().body(Map.of("reading", mypageService.getReadingBooks(myBookReqDto)));
    }

    @GetMapping("/reading/count")
    public ResponseEntity<?> getReadingBooksList(MyBookReqDto myBookReqDto) {
        return ResponseEntity.ok().body(mypageService.getReadingBooksCount(myBookReqDto));
    }

    @GetMapping("/returned")
    public ResponseEntity<?> getReturnedBooks(MyBookReqDto myBookReqDto) {
        return ResponseEntity.ok().body(Map.of("returned", mypageService.getReturnedBooks(myBookReqDto)));
    }

    @GetMapping("/returned/count")
    public ResponseEntity<?> getReturnedBooksList(MyBookReqDto myBookReqDto) {
        return ResponseEntity.ok().body(mypageService.getReturnedBooksCount(myBookReqDto));
    }

    @GetMapping("/wish")
    public ResponseEntity<?> getWishList(MyBookReqDto myBookReqDto) {
        return ResponseEntity.ok().body(Map.of("wishList", mypageService.getWishData(myBookReqDto)));
    }

    @GetMapping("/wish/count")
    public ResponseEntity<?> getWishCount(MyBookReqDto myBookReqDto) {
        return ResponseEntity.ok().body(mypageService.getWishCount(myBookReqDto));
    }

    @PutMapping("/profile")
    public ResponseEntity<?> updateProfileImage(@RequestBody UpdateProfileImageReqDto updateProfileImageReqDto) {
        return ResponseEntity.ok().body(mypageService.updateProfileImage(updateProfileImageReqDto));
    }
















}
