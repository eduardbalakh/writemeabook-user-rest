package com.writemeabook.restuserapi.service.subsection;

import com.writemeabook.restuserapi.VO.ResponseTemplateVO;
import com.writemeabook.restuserapi.VO.TextStory;
import com.writemeabook.restuserapi.dao.subsection.SubsectionDAO;
import com.writemeabook.restuserapi.hierarchicalmodel.Subsection;
import com.writemeabook.restuserapi.service.textstory.TextStoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.print.ServiceUI;
import java.util.LinkedList;
import java.util.List;

@Service
public class SubsectionServiceImpl implements SubsectionService {

    @Autowired
    private SubsectionDAO subsectionDAO;

    @Autowired
    private TextStoryService textStoryService;

    @Override
    @Transactional
    public Subsection getSubsection(Integer id) {
        return subsectionDAO.getSubsection(id);
    }

    @Override
    @Transactional
    public List<Subsection> getAllSubsections() {
        return subsectionDAO.getAllSubsections();
    }

    @Override
    @Transactional
    public Subsection saveSubsection(Subsection subsection) {
        if (subsection == null) throw new IllegalArgumentException("Subsection is null. Cannot save to DB");
            subsectionDAO.saveSubsection(subsection);
        return subsection;
    }



    @Override
    @Transactional
    public void deleteSubsection(Integer id) {
        Subsection subsectionToDelete = getSubsection(id);
        if (subsectionToDelete != null) {
            subsectionDAO.deleteSubsection(id);
            if (subsectionToDelete.getText() != null) {
                textStoryService.deleteText(subsectionToDelete.getText());
            }
        }
    }
}
