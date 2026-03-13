package com.example.usermanagement.service;

import com.example.usermanagement.entity.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    List<User>  getAllUserList();

    User getUserById(int id);

    String deleteUserById(int id);

    User updateUser(int id, User user);
}
