package com.t1.bookDrop.repository;

import com.t1.bookDrop.entity.Book;
import com.t1.bookDrop.entity.Loan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BookMapper {

    public int saveBook(Book book);

    public List<Book> getBook(
            @Param("bookId") int bookId
    );

    public List<Loan> getLoanPossibility(
            @Param("bookId") int bookId
    );

    public int deleteBookByBookIds(List<Integer> bookIds);

    public int updateBookByBookId(Book book);



}
