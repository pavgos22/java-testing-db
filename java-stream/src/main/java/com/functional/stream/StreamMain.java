package com.functional.stream;

import com.functional.stream.book.Book;
import com.functional.stream.book.BookDirectory;

public class StreamMain {

    public static void main(String[] args) {
        BookDirectory bd = new BookDirectory();

        System.out.println(bd.getList().get(1));
    }
}
