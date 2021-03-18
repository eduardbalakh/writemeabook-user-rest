package com.writemeabook.restuserapi.dao.chapter;

import com.writemeabook.restuserapi.model.Chapter;

import java.util.List;

public interface ChapterDAO {

    List<Chapter> getAllChapters();

    void saveChapter(Chapter chapter);

    Chapter getChapter(int id);

    void deleteChapter(int id);
}
