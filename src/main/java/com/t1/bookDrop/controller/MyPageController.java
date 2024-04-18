package com.t1.bookDrop.controller;

import com.t1.bookDrop.service.MypageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/mypage")
@RestController
public class MyPageController {

    @Autowired
    private MypageService mypageService;

    @GetMapping("/loan/{username}")
    public ResponseEntity<?> getLoanList(@PathVariable String username) {
        return ResponseEntity.ok().body(mypageService.getLoanData(username));
    }

    @GetMapping("/wish/{userid}")
    public ResponseEntity<?> getWishList(@PathVariable int userid) {
        return ResponseEntity.ok().body(mypageService.getWishData(userid));
    }
}
