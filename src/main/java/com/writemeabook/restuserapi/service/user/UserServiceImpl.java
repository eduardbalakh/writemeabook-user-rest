package com.writemeabook.restuserapi.service.user;


import com.writemeabook.restuserapi.dao.user.UserDAO;
import com.writemeabook.restuserapi.model.User;
import com.writemeabook.restuserapi.service.project.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private ProjectService projectService;

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    @Transactional
    public User saveUser(User user) {
        if (user == null) throw new IllegalArgumentException("User is null. Cannot save to DB");
        if (user.getBookProjects() != null && user.getBookProjects().size() > 0)
            user.getBookProjects().forEach(project -> projectService.saveProject(project));
        userDAO.saveUser(user);
        return user;
    }

    @Override
    @Transactional
    public User getUser(int id) {
        return userDAO.getUser(id);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        userDAO.deleteUser(id);
    }
}
