package com.t1.bookDrop.exception;

public class SaveException extends RuntimeException{

    public SaveException() {
        super("데이터 저장 오류");
    }
}
