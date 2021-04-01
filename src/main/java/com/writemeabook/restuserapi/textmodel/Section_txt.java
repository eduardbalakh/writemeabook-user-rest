package com.writemeabook.restuserapi.textmodel;

import com.writemeabook.restuserapi.VO.TextStory;
import com.writemeabook.restuserapi.hierarchicalmodel.Section;
import com.writemeabook.restuserapi.hierarchicalmodel.TreeTextEntity;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
public class Section_txt implements TreeTextEntity {

    private String title;

    private int numOrder;

    private List<Subsection_txt> subsections;

    private Integer text;


    public Section_txt(String title, int numOrder, TextStory text, Chapter_txt parentChapter) {
        this.title = title;
        this.numOrder = numOrder;
        parentChapter.addSectionToChapter(this);
    }

/*    public Section_txt(Section section, TextStory story) {
        this.title = section.getTitle();
        this.numOrder = section.getNumOrder();
        this.subsections = section.getSubsections().stream().peek(s->new Subsection_txt());

    }*/

    public void addSubsectionToSection(Subsection_txt newSubsection) {
        if (subsections == null) subsections = new ArrayList<>();
        subsections.add(Objects.requireNonNull(newSubsection));
    }
}
