package com.t1.bookDrop.controller;

import com.t1.bookDrop.dto.reqDto.UpdateProfileImageReqDto;
import com.t1.bookDrop.service.MypageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/mypage")
@RestController
public class MyPageController {

    @Autowired
    private MypageService mypageService;

    @GetMapping("/loan/{userid}")
    public ResponseEntity<?> getLoanList(@PathVariable int userid) {
        return ResponseEntity.ok().body(mypageService.getLoanData(userid));
    }

    @GetMapping("/wish/{userid}")
    public ResponseEntity<?> getWishList(@PathVariable int userid) {
        return ResponseEntity.ok().body(mypageService.getWishData(userid));
    }

    @PutMapping("/profile")
    public ResponseEntity<?> updateProfileImage(@RequestBody UpdateProfileImageReqDto updateProfileImageReqDto) {
        return ResponseEntity.ok().body(mypageService.updateProfileImage(updateProfileImageReqDto));
    }
}
