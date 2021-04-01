package com.writemeabook.restuserapi.service.project;


import com.writemeabook.restuserapi.hierarchicalmodel.BookProject;

import java.util.List;

public interface ProjectService {
    List<BookProject> getAllProjects();

    BookProject saveProject(BookProject project);

    BookProject getProject(int id);

    void deleteProject(int id);
}
