package com.t1.bookDrop.service;

import com.t1.bookDrop.dto.reqDto.SearchBookReqDto;
import com.t1.bookDrop.dto.respDto.LoanPossibilityRespDto;
import com.t1.bookDrop.dto.respDto.SearchBookRespDto;
import com.t1.bookDrop.entity.Book;
import com.t1.bookDrop.entity.Loan;
import com.t1.bookDrop.repository.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookInfoService {

    @Autowired
    private BookMapper bookMapper;

    public List<SearchBookRespDto> searchBookInfo(SearchBookReqDto searchBookReqDto){
        List<Book> bookInfo = bookMapper.getBook(
            searchBookReqDto.getBookId()
        );
        return bookInfo.stream().map(Book::toSearchBookRespDto).collect(Collectors.toList());
    }
    public List<LoanPossibilityRespDto> searchLoanPossibility(SearchBookReqDto searchBookReqDto) {
        List<Loan> loanInfo = bookMapper.getLoanPossibility(
                searchBookReqDto.getBookId()
        );
        return loanInfo.stream().map(Loan::toLoanPossibilityRespDto).collect(Collectors.toList());
    }
}
