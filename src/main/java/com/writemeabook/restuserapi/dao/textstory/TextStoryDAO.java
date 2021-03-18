package com.writemeabook.restuserapi.dao.textstory;

import com.writemeabook.restuserapi.model.TextStory;

import java.util.List;

public interface TextStoryDAO {

    List<TextStory> getAllTexts();

    void saveText(TextStory textStory);

    TextStory getText(int id);

    void deleteTextStory(int id);

}
