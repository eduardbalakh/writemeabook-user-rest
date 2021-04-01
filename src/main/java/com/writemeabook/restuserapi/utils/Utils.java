package com.writemeabook.restuserapi.utils;

import com.writemeabook.restuserapi.VO.TextStory;
import com.writemeabook.restuserapi.hierarchicalmodel.*;
import com.writemeabook.restuserapi.service.textstory.TextStoryService;
import com.writemeabook.restuserapi.textmodel.*;
import org.springframework.web.client.RestTemplate;

public class Utils {

/*    public static BookProject_txt getTextProject(BookProject project, RestTemplate restTemplate) {

    }

    private static Book_txt getTextBook(Book book, TextStoryService service) {

    }

    private static Chapter_txt getTextChapter(Chapter chapter, TextStoryService service) {

    }*/
/*
    private static Section_txt getTextSection(Section section, TextStoryService service) {
        TextStory textStory = null;
        //if()
        return new Section_txt();
    }*/

    private static Subsection_txt getTextSubsection(Subsection subsection, TextStoryService service) {
        TextStory textStory = null;
        if (subsection.getText() != null) {
            textStory = service.getText(subsection.getText());
        }
        return new Subsection_txt(subsection, textStory);
    }
}
