package com.t1.bookDrop.service;

import com.t1.bookDrop.dto.reqDto.AdminBookReqDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.t1.bookDrop.repository.AdminBookMapper;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminBookService {

    @Autowired
    private AdminBookMapper adminBookMapper;

    @Transactional(rollbackFor = Exception.class)
    public void saveBook (AdminBookReqDto adminBookReqDto) {
        adminBookMapper.saveBook(adminBookReqDto.toEntity());
    }
}
