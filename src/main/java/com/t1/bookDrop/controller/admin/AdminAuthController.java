package com.t1.bookDrop.controller.admin;

import com.t1.bookDrop.dto.AdminSigninDto;
import com.t1.bookDrop.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AdminAuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/admin/signin")
    public ResponseEntity<?> adminSignin (@RequestBody AdminSigninDto adminSigninDto) {
        return ResponseEntity.ok(authService.authSignin(adminSigninDto));
    }
}
