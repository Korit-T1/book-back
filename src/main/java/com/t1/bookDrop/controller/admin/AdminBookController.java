package com.t1.bookDrop.controller.admin;



import com.t1.bookDrop.aop.annotation.ParamsPrintAspect;
import com.t1.bookDrop.aop.annotation.ValidAspect;
import com.t1.bookDrop.dto.reqDto.RegisterBookReqDto;
import com.t1.bookDrop.dto.reqDto.SearchBookReqDto;
import com.t1.bookDrop.dto.reqDto.UpdateBookReqDto;
import com.t1.bookDrop.service.BookInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/admin")
public class AdminBookController {


    @Autowired
    private BookInfoService bookInfoService;


    @ParamsPrintAspect
    @ValidAspect
    @PostMapping("/book/save")
    public ResponseEntity<?> saveBook( @Valid @RequestBody RegisterBookReqDto registerBookReqDto, BindingResult bindingResult) {
        bookInfoService.saveBook(registerBookReqDto);
        return ResponseEntity.created(null).body(true);
    }


    @GetMapping("/book/search")
    public ResponseEntity<?> searchBookInfo(SearchBookReqDto searchBookReqDto) {
        return ResponseEntity.ok(bookInfoService.searchBookInfo(searchBookReqDto    ));
    }


//    @GetMapping("/book/count")
//    public ResponseEntity<?> getCount(SearchBooksReqDto searchBooksReqDto) {
//        return ResponseEntity.ok(bookService.getBookCount(searchBooksReqDto));
//    }



    @DeleteMapping("/book/delete")
    public  ResponseEntity<?> deleteBook(@RequestBody List<Integer> bookIds) {
        bookInfoService.deleteBook(bookIds);
        return ResponseEntity.ok(true);
    }


    @ParamsPrintAspect
    @PutMapping("/book/update/{bookId}")
    public ResponseEntity<?> updateBook(
            @PathVariable int bookId,
            @RequestBody UpdateBookReqDto updateBookReqDto) {
        System.out.println(updateBookReqDto);
        bookInfoService.updateBook(updateBookReqDto);
        return ResponseEntity.ok(true);
    }

}