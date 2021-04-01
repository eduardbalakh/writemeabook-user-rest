package com.writemeabook.restuserapi.service.book;


import com.writemeabook.restuserapi.hierarchicalmodel.Book;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();

    void saveBook(Book book);

    Book getBook(int id);

    void deleteBook(int id);
}
