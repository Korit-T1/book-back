package com.t1.bookDrop.controller.admin;

import com.t1.bookDrop.aop.annotation.ParamsPrintAspect;
import com.t1.bookDrop.aop.annotation.ValidAspect;
import com.t1.bookDrop.dto.reqDto.AdminBookReqDto;
import com.t1.bookDrop.dto.reqDto.RegisterBookReqDto;
import com.t1.bookDrop.dto.reqDto.UpdateBookReqDto;
import com.t1.bookDrop.service.AdminBookService;
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

    @Autowired
    private AdminBookService adminBookService;


    @ValidAspect
    @PostMapping("/bookRegistration")
    public ResponseEntity<?> registrationBook(@Valid @RequestBody AdminBookReqDto adminBookReqDto, BindingResult bindingResult){
        adminBookService.saveBook(adminBookReqDto);
        return ResponseEntity.created(null).body(true);
    }

    @GetMapping("/getCategory")
    public ResponseEntity<?> getCategory() {
        return ResponseEntity.ok(adminBookService.getCategories());
    }

    @DeleteMapping("/book")
    public  ResponseEntity<?> deleteBook(@RequestBody List<Integer> bookIds) {
        bookInfoService.deleteBook(bookIds);
        return ResponseEntity.ok(true);
    }

    @ParamsPrintAspect
    @PutMapping("/book/{bookId}")
    public ResponseEntity<?> updateBook(
            @PathVariable int bookId,
            @RequestBody UpdateBookReqDto updateBookReqDto) {
        System.out.println(updateBookReqDto);
        bookInfoService.updateBook(updateBookReqDto);
        return ResponseEntity.ok(true);
    }
}
