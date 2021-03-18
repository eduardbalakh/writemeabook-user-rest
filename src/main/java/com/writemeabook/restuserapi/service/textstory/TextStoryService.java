package com.writemeabook.restuserapi.service.textstory;

import com.writemeabook.restuserapi.model.TextStory;

import java.util.List;

public interface TextStoryService {
    List<TextStory> getAllTexts();

    void saveText(TextStory textStory);

    TextStory getText(int id);

    void deleteText(int id);
}
