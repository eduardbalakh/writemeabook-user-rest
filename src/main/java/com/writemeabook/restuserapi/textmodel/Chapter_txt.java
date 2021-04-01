package com.writemeabook.restuserapi.textmodel;

import com.writemeabook.restuserapi.VO.TextStory;
import com.writemeabook.restuserapi.hierarchicalmodel.TreeTextEntity;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
public class Chapter_txt implements TreeTextEntity {

    private String title;

    private int numOrder;

    private List<Section_txt> sections;

    private TextStory text;

    public Chapter_txt(String title, int numOrder, TextStory text, Book_txt parentBook) {
        this.title = title;
        this.numOrder = numOrder;
        parentBook.addChapterToBook(this);
    }

    public void addSectionToChapter(Section_txt newSection) {
        if (sections == null) sections = new ArrayList<>();
        sections.add(Objects.requireNonNull(newSection));
    }
}
