package com.t1.bookDrop.controller;

import com.t1.bookDrop.dto.reqDto.SearchBookReqDto;
import com.t1.bookDrop.dto.respDto.SearchBookRespDto;
import com.t1.bookDrop.service.BookInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class BookInfoController {

    @Autowired
    private BookInfoService bookInfoService;

    @GetMapping("/book/{bookId}")   //삭제 예정
    public ResponseEntity<List<SearchBookRespDto>> searchBookInfo(@PathVariable int bookId){
        List<SearchBookRespDto> bookInfo = bookInfoService.searchBookInfo(bookId);
        return ResponseEntity.ok(bookInfo);
    }

//    @GetMapping("/books")
//    public ResponseEntity<?> searchBooks(SearchBookReqDto searchBookReqDto) {
//        return ResponseEntity.ok(Map.of("searchText", searchBookReqDto.getText(), "books", bookInfoService.getBooks(searchBookReqDto)));
//    }

  @GetMapping("/books")
    public ResponseEntity<?> searchBooks(SearchBookReqDto searchBookReqDto) {
        return ResponseEntity.ok(bookInfoService.getBooks(searchBookReqDto));
    }

    @GetMapping("/books/count")
    public ResponseEntity<?> getCount(SearchBookReqDto searchBookReqDto) {
        return ResponseEntity.ok(bookInfoService.getBookCount(searchBookReqDto));
    }

    @GetMapping("/book/{bookId}/stocks")
    public ResponseEntity<?> getBookStocks(@PathVariable int bookId) {
        return ResponseEntity.ok(bookInfoService.getBookStocks(bookId));
    }

}
