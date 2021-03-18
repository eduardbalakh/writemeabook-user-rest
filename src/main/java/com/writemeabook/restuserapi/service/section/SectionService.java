package com.writemeabook.restuserapi.service.section;


import com.writemeabook.restuserapi.model.Section;

import java.util.List;

public interface SectionService {
    List<Section> getAllSections();

    Section saveSection(Section section);

    Section getSection(int id);

    void deleteSection(int id);
}
