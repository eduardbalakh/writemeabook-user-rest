package com.writemeabook.restuserapi.dao.section;

import com.writemeabook.restuserapi.model.Section;

import java.util.List;

public interface SectionDAO {
    List<Section> getAllSections();

    void saveSection(Section section);

    Section getSection(int id);

    void deleteSection(int id);
}
