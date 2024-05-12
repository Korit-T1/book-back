package com.t1.bookDrop.controller;

//import com.study.library.aop.annotation.ValidAspect;
//import com.study.library.dto.EditPasswordReqDto;
//import com.study.library.security.PrincipalUser;
import com.t1.bookDrop.aop.annotation.ValidAspect;
import com.t1.bookDrop.dto.reqDto.EditPasswordReqDto;
import com.t1.bookDrop.security.PrincipalUser;
import com.t1.bookDrop.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/account")
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/principal")
    public ResponseEntity<?> getPrincipal() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PrincipalUser principalUser = (PrincipalUser) authentication.getPrincipal();
        System.out.println(principalUser);
        return ResponseEntity.ok().body(principalUser);
    }

    @ValidAspect
    @PutMapping("/password")
    public ResponseEntity<?> editPassword(@Valid @RequestBody EditPasswordReqDto editPasswordReqDto, BindingResult bindingResult) {
        accountService.editPassword(editPasswordReqDto);

        return ResponseEntity.ok(true);
    }

}
