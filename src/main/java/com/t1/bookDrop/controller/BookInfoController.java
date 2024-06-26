package com.t1.bookDrop.controller;

import com.t1.bookDrop.aop.annotation.ParamsPrintAspect;
import com.t1.bookDrop.dto.reqDto.SearchBookReqDto;
import com.t1.bookDrop.dto.respDto.SearchBookRespDto;
import com.t1.bookDrop.service.BookInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class BookInfoController {

    @Autowired
    private BookInfoService bookInfoService;


    @GetMapping("/books")
    public ResponseEntity<?> searchBooks(SearchBookReqDto searchBookReqDto) {
        return ResponseEntity.ok(bookInfoService.getBooks(searchBookReqDto));
    }

    @GetMapping("/books/count")
    public ResponseEntity<?> getCount(SearchBookReqDto searchBookReqDto) {
        return ResponseEntity.ok(bookInfoService.getBookCount(searchBookReqDto));
    }

    @GetMapping("/books/{bookId}/stocks")
    public ResponseEntity<?> getBookStocks(@PathVariable int bookId) {
        return ResponseEntity.ok(bookInfoService.getBookStocks(bookId));
    }

    @GetMapping("/books/popular")
    public ResponseEntity<?> getPopularBooks() {
        return ResponseEntity.ok(bookInfoService.getPopularBooks());
    }

    @GetMapping("/books/top5")
    public ResponseEntity<?> getTopFiveBooks() {
        return ResponseEntity.ok(bookInfoService.getTopFiveBooks());
    }

    @GetMapping("/books/new")
    public ResponseEntity<?> getNewBooks() {
        return ResponseEntity.ok(bookInfoService.getNewBooks());
    }

}
