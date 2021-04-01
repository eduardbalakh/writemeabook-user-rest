package com.writemeabook.restuserapi.service.chapter;

import com.writemeabook.restuserapi.dao.chapter.ChapterDAO;
import com.writemeabook.restuserapi.hierarchicalmodel.Chapter;
import com.writemeabook.restuserapi.service.section.SectionService;
import com.writemeabook.restuserapi.service.textstory.TextStoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ChapterServiceImpl implements ChapterService {

    @Autowired
    private ChapterDAO chapterDAO;
    @Autowired
    private SectionService sectionService;
    @Autowired
    private TextStoryService textStoryService;

    @Override
    @Transactional
    public Chapter getChapter(Integer id) {
        return chapterDAO.getChapter(id);
    }

    @Override
    @Transactional
    public List<Chapter> getAllChapters() {
        return chapterDAO.getAllChapters();
    }

    @Override
    @Transactional
    public Chapter saveChapter(Chapter chapter) {
        if (chapter == null) throw new IllegalArgumentException("Chapter is null. Cannot save to DB");
        if (chapter.getSections() != null && chapter.getSections().size() > 0)
            chapter.getSections().forEach(section -> {
                sectionService.saveSection(section);
            });
        chapterDAO.saveChapter(chapter);
        return chapter;
    }


    @Override
    @Transactional
    public void deleteChapter(Integer id) {
        Chapter chapterToDelete = getChapter(id);
        if (chapterToDelete != null) {
            if (chapterToDelete.getSections() != null && chapterToDelete.getSections().size() > 0) {
                chapterToDelete.getSections().forEach(section -> {
                    sectionService.deleteSection(section.getId());
                });
            }

            chapterDAO.deleteChapter(id);
            if (chapterToDelete.getText() != null) {
                textStoryService.deleteText(chapterToDelete.getText());
            }
        }
    }
}

