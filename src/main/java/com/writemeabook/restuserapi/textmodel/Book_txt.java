package com.writemeabook.restuserapi.textmodel;

import com.writemeabook.restuserapi.hierarchicalmodel.TreeTextEntity;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
public class Book_txt implements TreeTextEntity {

    private String title;

    private int numOrder;

    private List<Chapter_txt> chapters;

    public Book_txt() {
    }

    public Book_txt(String title, int numOrder, BookProject_txt parentBookProject) {
        this.title = title;
        this.numOrder = numOrder;
        parentBookProject.addBookToProject(this);
    }

    public void addChapterToBook(Chapter_txt newChapter) {
        if (chapters == null)
            chapters = new ArrayList<>();
        chapters.add(Objects.requireNonNull(newChapter));
    }

}
