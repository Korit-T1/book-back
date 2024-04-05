package com.t1.bookDrop.controller;

import com.t1.bookDrop.dto.reqDto.SearchBookReqDto;
import com.t1.bookDrop.dto.respDto.LoanPossibilityRespDto;
import com.t1.bookDrop.dto.respDto.SearchBookRespDto;
import com.t1.bookDrop.service.BookInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookInfoController {

    @Autowired
    private BookInfoService bookInfoService;

    @Autowired
    private SearchBookReqDto searchBookReqDto;


    @GetMapping("/{bookId}")
    public ResponseEntity<List<SearchBookRespDto>> searchBookInfo(@PathVariable int bookId){
        searchBookReqDto.setBookId(bookId);
        List<SearchBookRespDto> bookInfo = bookInfoService.searchBookInfo(searchBookReqDto);
        return ResponseEntity.ok(bookInfo);
    }
    @GetMapping("/{bookId}/loanStatus")
    public ResponseEntity<List<LoanPossibilityRespDto>> searchLoanPossibility(@PathVariable int bookId){
        searchBookReqDto.setBookId(bookId);
        List<LoanPossibilityRespDto> loanInfo = bookInfoService.searchLoanPossibility(searchBookReqDto);
        return ResponseEntity.ok(loanInfo);
    }

}
