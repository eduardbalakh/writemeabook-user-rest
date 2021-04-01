package com.writemeabook.restuserapi.service.textstory;

import com.writemeabook.restuserapi.VO.TextStory;

import java.util.List;

public interface TextStoryService {
    List<TextStory> getAllTexts();

    TextStory saveText(TextStory textStory);

    TextStory getText(Integer id);

    void deleteText(Integer id);
}
