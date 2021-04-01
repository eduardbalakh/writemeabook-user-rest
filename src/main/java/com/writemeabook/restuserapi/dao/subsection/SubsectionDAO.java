package com.writemeabook.restuserapi.dao.subsection;

import com.writemeabook.restuserapi.hierarchicalmodel.Subsection;

import java.util.List;

public interface SubsectionDAO {
    List<Subsection> getAllSubsections();

    void saveSubsection(Subsection subsection);

    Subsection getSubsection(int id);

    void deleteSubsection(int id);
}
