package com.writemeabook.restuserapi.service.subsection;


import com.writemeabook.restuserapi.model.Subsection;

import java.util.List;

public interface SubsectionService {

    List<Subsection> getAllSubsections();

    Subsection saveSubsection(Subsection subsection);

    Subsection getSubsection(int id);

    void deleteSubsection(int id);
}
