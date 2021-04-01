package com.writemeabook.restuserapi.textmodel;

import com.writemeabook.restuserapi.VO.TextStory;
import com.writemeabook.restuserapi.hierarchicalmodel.Subsection;
import com.writemeabook.restuserapi.hierarchicalmodel.TreeTextEntity;
import lombok.Data;

@Data
public class Subsection_txt implements TreeTextEntity {

    private String title;

    private int numOrder;

    private TextStory text;

    public Subsection_txt(String title, int numOrder, TextStory text, Section_txt parentSection) {
        this.title = title;
        this.numOrder = numOrder;
        parentSection.addSubsectionToSection(this);
    }

    public Subsection_txt(Subsection subsection, TextStory story) {
        this.title = subsection.getTitle();
        this.numOrder = subsection.getNumOrder();
        this.text = story;
    }
}

