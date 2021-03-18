package com.writemeabook.restuserapi.service.chapter;


import com.writemeabook.restuserapi.model.Chapter;

import java.util.List;

public interface ChapterService {
    List<Chapter> getAllChapters();

    Chapter saveChapter(Chapter chapter);

    Chapter getChapter(int id);

    void deleteChapter(int id);
}
