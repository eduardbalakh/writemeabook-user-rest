package com.writemeabook.restuserapi.dao.chapter;

import com.writemeabook.restuserapi.hierarchicalmodel.Chapter;

import java.util.List;

public interface ChapterDAO {

    List<Chapter> getAllChapters();

    Chapter saveChapter(Chapter chapter);

    Chapter getChapter(Integer id);

    void deleteChapter(Integer id);
}
