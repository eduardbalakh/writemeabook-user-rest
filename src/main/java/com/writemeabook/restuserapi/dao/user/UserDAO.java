package com.writemeabook.restuserapi.dao.user;

import com.writemeabook.restuserapi.hierarchicalmodel.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();

    void saveUser(User user);

    User getUser(int id);

    void deleteUser(int id);
}
