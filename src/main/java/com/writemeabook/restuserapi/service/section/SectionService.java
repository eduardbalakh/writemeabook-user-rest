package com.writemeabook.restuserapi.service.section;


import com.writemeabook.restuserapi.VO.ResponseTemplateVO;
import com.writemeabook.restuserapi.hierarchicalmodel.Section;

import java.util.List;

public interface SectionService {
    List<Section> getAllSections();

    Section saveSection(Section section);

    Section getSection(Integer id);

    void deleteSection(Integer id);
}
