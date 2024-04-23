package com.t1.bookDrop.service;

import com.t1.bookDrop.dto.reqDto.RegisterBookReqDto;
import com.t1.bookDrop.dto.reqDto.SearchBookReqDto;
import com.t1.bookDrop.dto.reqDto.UpdateBookReqDto;
import com.t1.bookDrop.dto.respDto.GetBookStocksRespDto;
import com.t1.bookDrop.dto.respDto.SearchBookCountRespDto;
import com.t1.bookDrop.dto.respDto.SearchBookRespDto;
import com.t1.bookDrop.entity.Book;
import com.t1.bookDrop.entity.BookStock;
import com.t1.bookDrop.repository.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookInfoService {
    @Autowired
    private BookMapper bookMapper;

    @Transactional(rollbackFor = Exception.class)
    public void saveBook(RegisterBookReqDto registerBookReqDto) {
        bookMapper.saveBook(registerBookReqDto.toEntity());
    }

    public List<SearchBookRespDto> searchBookInfo(int bookId){ // 삭제 예정
        List<Book> bookInfo = bookMapper.getBook(bookId);
        return bookInfo.stream().map(Book::toSearchBookRespDto).collect(Collectors.toList());
    }

    public List<SearchBookRespDto> getBooks(SearchBookReqDto searchBookReqDto) {
        int index = (searchBookReqDto.getPage() - 1) * 20;
        List<Book> books = bookMapper.findBooksAll(
                index,
                searchBookReqDto.getCount(),
                searchBookReqDto.getOption(),
                searchBookReqDto.getText()
        );
        return books.stream().map(Book::toSearchBookRespDto).collect(Collectors.toList());
    }

    public List<GetBookStocksRespDto> getBookStocks(int bookId) {
        return bookMapper.findBookStocksByBookId(bookId).stream().map(BookStock::toDto).collect(Collectors.toList());
    }

    public SearchBookCountRespDto getBookCount(SearchBookReqDto searchBookReqDto) {
        int bookCount = bookMapper.getBookCount(
                searchBookReqDto.getOption(),
                searchBookReqDto.getText()
        );

        return SearchBookCountRespDto.builder()
                .totalCount(bookCount)
                .build();
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteBook(List<Integer> bookIds) {
        bookMapper.deleteBookByBookIds(bookIds);
    }

    @Transactional(rollbackFor = Exception.class)
    public void updateBook(UpdateBookReqDto updateBookReqDto) {
        bookMapper.updateBookByBookId(updateBookReqDto.toEntity());
    }
}
