package com.writemeabook.restuserapi.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseTemplateVO<T> {

    private T entity;
    private TextStory textStory;
}
