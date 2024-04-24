package com.t1.bookDrop.controller.admin;

import com.t1.bookDrop.aop.annotation.ValidAspect;
import com.t1.bookDrop.dto.reqDto.NoticeBoardReqDto;
import com.t1.bookDrop.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/admin")
public class AdminBoardController {

    @Autowired
    private NoticeService noticeService;

    @ValidAspect
    @PostMapping("/notice")
    public ResponseEntity<?> newNotice(@Valid @RequestBody NoticeBoardReqDto noticeBoardReqDto, BindingResult NoticeBoardReqDto) {
        noticeService.saveNotice(noticeBoardReqDto);
        return ResponseEntity.created(null).body(true);
    }

}
