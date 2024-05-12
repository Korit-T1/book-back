package com.t1.bookDrop.controller.admin;

import com.t1.bookDrop.dto.reqDto.AdminUserReqDto;
import com.t1.bookDrop.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminUserController {

    @Autowired
    private AdminUserService adminUserService;

    @GetMapping("/adminUser")
    public ResponseEntity<?> getUser(AdminUserReqDto adminUserReqDto) {
        return ResponseEntity.ok(adminUserService.getUsers(adminUserReqDto));
    }

    @GetMapping("/findUser")
    public ResponseEntity<?> findUser(@RequestBody AdminUserReqDto adminUserReqDto) {
        return ResponseEntity.ok(adminUserService.findUser(adminUserReqDto));
    }
}
