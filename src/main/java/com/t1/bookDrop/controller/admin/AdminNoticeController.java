package com.t1.bookDrop.controller.admin;

import com.t1.bookDrop.aop.annotation.ValidAspect;
import com.t1.bookDrop.dto.reqDto.NoticeReqDto;
import com.t1.bookDrop.dto.respDto.NoticeRespDto;
import com.t1.bookDrop.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminNoticeController {

    @Autowired
    private NoticeService noticeService;

    @ValidAspect
    @PostMapping("/notice")
    public ResponseEntity<?> newNotice(@Valid @RequestBody NoticeReqDto noticeBoardReqDto, BindingResult NoticeBoardReqDto) {
        noticeService.saveNotice(noticeBoardReqDto);
        return ResponseEntity.created(null).body(true);
    }

    @GetMapping("/getNotice/{noticeBoardId}")
    public ResponseEntity<List<NoticeRespDto>> findNotice(@PathVariable int noticeBoardId){
        return ResponseEntity.ok(noticeService.getNotice(noticeBoardId));
    }

    @DeleteMapping("/notice")
    public ResponseEntity<?> deleteNotice(@RequestBody List<Integer> noticeIds) {
        noticeService.deleteNotice(noticeIds);
        return ResponseEntity.ok(true);
    }

}
