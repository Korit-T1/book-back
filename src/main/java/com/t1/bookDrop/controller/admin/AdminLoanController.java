package com.t1.bookDrop.controller.admin;

import com.t1.bookDrop.service.AdminLoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminLoanController {

    @Autowired
    private AdminLoanService adminLoanService;

    @GetMapping("/adminLoan")
    public ResponseEntity<?> getLoanData() {
        return ResponseEntity.ok(adminLoanService.getLoans());
    }
    @GetMapping("/adminReturn")
    public ResponseEntity<?> getReturnDate() {
        return ResponseEntity.ok(adminLoanService.gteReturns());
    }

    @PutMapping("/adminReturnOrNot/{loanId}")
    public ResponseEntity<?> putReturnOrNot(@PathVariable int loanId){
        adminLoanService.updateReturn(loanId);
        return ResponseEntity.ok(true);
    }
    @GetMapping("/adminOverdue")
    public ResponseEntity<?> getOverdue() {
        return ResponseEntity.ok(adminLoanService.getOverdues());
    }
}
