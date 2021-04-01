package com.writemeabook.restuserapi.textmodel;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
public class BookProject_txt {

    private String title;

    private int numOrder;

    private List<Book_txt> books;

    public BookProject_txt(String title, int numOrder) {
        this.title = title;
        this.numOrder = numOrder;
    }

    public BookProject_txt(String projectName) {
        this.title = projectName;
    }

    public void addBookToProject(Book_txt newBook) {
        if (books == null) books = new ArrayList<>();
        books.add(Objects.requireNonNull(newBook));
    }

}
