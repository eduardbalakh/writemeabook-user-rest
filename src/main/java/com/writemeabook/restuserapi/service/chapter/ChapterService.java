package com.writemeabook.restuserapi.service.chapter;

import com.writemeabook.restuserapi.hierarchicalmodel.Chapter;

import java.util.List;

public interface ChapterService {
    List<Chapter> getAllChapters();

    Chapter saveChapter(Chapter chapter);

    Chapter getChapter(Integer id);

    void deleteChapter(Integer id);
}
