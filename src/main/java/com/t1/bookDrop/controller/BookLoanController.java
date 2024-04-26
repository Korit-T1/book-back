package com.t1.bookDrop.controller;

import com.t1.bookDrop.aop.annotation.ValidAspect;
import com.t1.bookDrop.dto.reqDto.LoanReqDto;
import com.t1.bookDrop.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/loan")
public class  BookLoanController {

    @Autowired
    private LoanService loanService;

    @ValidAspect
    @PostMapping("/loanRequest")
    public ResponseEntity<?> loanSave(@Valid @RequestBody LoanReqDto loanReqDto, BindingResult bindingResult){
        loanService.saveLoan(loanReqDto);
        return ResponseEntity.created(null).body(true);
    }

    @PutMapping("/loanRequest/{loanId}")
    public ResponseEntity<?> updateReturnDate(@PathVariable int loanId){
        loanService.updateReturn(loanId);
        return ResponseEntity.ok(true);
    }
}
