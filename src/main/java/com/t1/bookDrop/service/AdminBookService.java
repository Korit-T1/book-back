package com.t1.bookDrop.service;

import com.t1.bookDrop.dto.reqDto.AdminBookReqDto;
import com.t1.bookDrop.entity.Category;
import com.t1.bookDrop.repository.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.t1.bookDrop.repository.AdminBookMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminBookService {

    @Autowired
    private AdminBookMapper adminBookMapper;

    @Autowired
    private BookMapper bookMapper;

    @Transactional(rollbackFor = Exception.class)
    public void saveBook (AdminBookReqDto adminBookReqDto) {
        adminBookMapper.saveBook(adminBookReqDto.toEntity());
    }

    public List<Category> getCategories() {
        return bookMapper.getCategory();
    }
}
