package com.writemeabook.restuserapi.dao.project;

import com.writemeabook.restuserapi.model.BookProject;

import java.util.List;

public interface BookProjectDAO {
    List<BookProject> getAllProjects();

    void saveProject(BookProject project);

    BookProject getProject(int id);

    void deleteProject(int id);
}
