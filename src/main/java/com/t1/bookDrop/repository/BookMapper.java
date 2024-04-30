package com.t1.bookDrop.repository;

import com.t1.bookDrop.entity.Book;
import com.t1.bookDrop.entity.BookStock;
import com.t1.bookDrop.entity.Loan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BookMapper {

    public int saveBook(Book book);
    public int saveLoan(Loan loan);

//    public List<Book> getBook( // 기능 확인
//            @Param("bookId") int bookId
//    );

    public List<Book> findBooksAll(
            @Param("index") int index,
            @Param("count") int count,
            @Param("option")int option,
            @Param("text")String text);


    public int getBookCount(
            @Param("option") int option,
            @Param("text") String text);

    public int deleteBookByBookIds(List<Integer> bookIds);

    public int updateBookByBookId(Book book);

    public int updateReturnDate(int loanId);



    public List<BookStock> findBookStocksByBookId(int bookId);
}
