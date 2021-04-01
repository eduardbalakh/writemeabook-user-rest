package com.writemeabook.restuserapi.VO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TextStory {

    private Integer id;
    private String text;

    public TextStory(String text) {
        this.text = text;
    }

}
