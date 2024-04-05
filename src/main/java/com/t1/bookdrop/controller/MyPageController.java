package com.t1.bookdrop.controller;

import com.t1.bookdrop.service.MypageService;
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

    @GetMapping("/loan/{userId}")
    public ResponseEntity<?> getLoanList(@PathVariable int userId) {
        return ResponseEntity.ok().body(mypageService.getLoanData(userId));
    }

    @GetMapping("/test")
    public ResponseEntity<?> test() {
        System.out.println("test");
        return ResponseEntity.ok().body("test");
    }

}
