package com.writemeabook.restuserapi.service.section;


import com.writemeabook.restuserapi.VO.ResponseTemplateVO;
import com.writemeabook.restuserapi.VO.TextStory;
import com.writemeabook.restuserapi.dao.section.SectionDAO;
import com.writemeabook.restuserapi.hierarchicalmodel.Section;
import com.writemeabook.restuserapi.service.subsection.SubsectionService;
import com.writemeabook.restuserapi.service.textstory.TextStoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SectionServiceImpl implements SectionService {

    @Autowired
    private SectionDAO sectionDAO;
    @Autowired
    private SubsectionService subsectionService;
    @Autowired
    private TextStoryService textStoryService;

    @Override
    @Transactional
    public Section getSection(Integer id) {
        return sectionDAO.getSection(id);
    }

    @Override
    @Transactional
    public List<Section> getAllSections() {
        return sectionDAO.getAllSections();
    }

    @Override
    @Transactional
    public Section saveSection(Section section) {
        if (section == null) throw new IllegalArgumentException("Section is null. Cannot save to DB");
        if (section.getSubsections() != null && section.getSubsections().size() > 0)
            section.getSubsections().forEach(subsection -> {
                subsectionService.saveSubsection(subsection);
            });
        sectionDAO.saveSection(section);
        return section;
    }


    @Override
    @Transactional
    public void deleteSection(Integer id) {
        Section sectionToDelete = getSection(id);
        if (sectionToDelete != null) {
            if (sectionToDelete.getSubsections() != null && sectionToDelete.getSubsections().size() > 0) {
                sectionToDelete.getSubsections().forEach((subsection) -> {
                    subsectionService.deleteSubsection(subsection.getId());
                });
            }
            sectionDAO.deleteSection(id);
            if (sectionToDelete.getText() != null) {
                textStoryService.deleteText(sectionToDelete.getText());
            }
        }
    }
}

