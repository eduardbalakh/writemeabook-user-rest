package com.writemeabook.restuserapi.service.subsection;


import com.writemeabook.restuserapi.VO.ResponseTemplateVO;
import com.writemeabook.restuserapi.hierarchicalmodel.Subsection;

import java.util.List;

public interface SubsectionService {

    List<Subsection> getAllSubsections();

    Subsection saveSubsection(Subsection subsection);

    Subsection getSubsection(Integer id);

    void deleteSubsection(Integer id);
}
