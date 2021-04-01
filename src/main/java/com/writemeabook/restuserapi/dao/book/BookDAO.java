package com.writemeabook.restuserapi.dao.book;


import com.writemeabook.restuserapi.hierarchicalmodel.Book;

import java.util.List;

public interface BookDAO {
    List<Book> getAllBooks();

    void saveBook(Book project);

    Book getBook(int id);

    void deleteBook(int id);
}
