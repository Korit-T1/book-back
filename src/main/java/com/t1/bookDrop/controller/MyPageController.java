package com.t1.bookDrop.controller;

import com.t1.bookDrop.dto.reqDto.GetWishReqDto;
import com.t1.bookDrop.dto.reqDto.UpdateProfileImageReqDto;
import com.t1.bookDrop.service.MypageService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/mypage")
@RestController
public class MyPageController {

    @Autowired
    private MypageService mypageService;

    @GetMapping("/loan/{userid}")
    public ResponseEntity<?> getLoanList(@PathVariable int userid) {
        return ResponseEntity.ok().body(mypageService.getLoanData(userid));
    }

    @GetMapping("/wish")
    public ResponseEntity<?> getWishList(GetWishReqDto getWishReqDto) {
        return ResponseEntity.ok().body(Map.of(
                "wishList", mypageService.getWishData(getWishReqDto))
        );
    }

    @GetMapping("/wish/count")
    public ResponseEntity<?> getWishCount(GetWishReqDto getWishReqDto) {
        return ResponseEntity.ok().body(mypageService.getWishCount(getWishReqDto));
    }

    @PutMapping("/profile")
    public ResponseEntity<?> updateProfileImage(@RequestBody UpdateProfileImageReqDto updateProfileImageReqDto) {
        return ResponseEntity.ok().body(mypageService.updateProfileImage(updateProfileImageReqDto));
    }
















}
