package com.writemeabook.restuserapi.service.textstory;

import com.writemeabook.restuserapi.VO.TextStory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class TextStoryServiceImpl implements TextStoryService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    @Transactional
    public List<TextStory> getAllTexts() {
        return Arrays.asList(Objects.requireNonNull(restTemplate.getForObject("http://localhost:9089/texts/", TextStory[].class)).clone());
    }

    @Override
    @Transactional
    public TextStory saveText(TextStory textStory) {
        if (textStory.getId() == null && textStory.getId() == 0)
            restTemplate.postForObject("http://localhost:9089/texts/", textStory, TextStory.class);
        else restTemplate.put("http://localhost:9089/texts/", textStory);
        return textStory;
        //textStoryDAO.saveText(textStory);
    }

    @Override
    @Transactional
    public TextStory getText(Integer id) {
        return restTemplate.getForObject("http://localhost:9089/texts/" + id, TextStory.class);
    }

    @Override
    @Transactional
    public void deleteText(Integer id) {
        restTemplate.delete("http://localhost:9089/texts/" + id);
        //textStoryDAO.deleteTextStory(id);
    }
}
