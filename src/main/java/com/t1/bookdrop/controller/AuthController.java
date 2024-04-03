package com.t1.bookdrop.controller;

import com.t1.bookdrop.aop.annotation.ParamsPrintAspect;
import com.t1.bookdrop.dto.SignupReqDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @ParamsPrintAspect
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupReqDto signupReqDto) {
        return ResponseEntity.ok(null);
    }
}
