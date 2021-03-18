package com.writemeabook.restuserapi.service.user;

import com.writemeabook.restuserapi.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User saveUser(User user);

    User getUser(int id);

    void deleteUser(int id);
}
