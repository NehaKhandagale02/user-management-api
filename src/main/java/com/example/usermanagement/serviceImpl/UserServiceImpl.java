package com.example.usermanagement.serviceImpl;

import com.example.usermanagement.entity.User;
import com.example.usermanagement.repository.UserRepository;
import com.example.usermanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.usermanagement.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        User newUser = userRepository.save(user);
        System.err.println("user saved Successfully");
        return newUser;
    }

    @Override
    public List<User> getAllUserList() {
        List<User> userList = userRepository.findAll();
        return userList;
    }

    @Override
    public User getUserById(int id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException("User is not available with id : " + id)
        );
        return user;
    }

    @Override
    public String deleteUserById(int id) {
        userRepository.deleteById(id);
        String msg = "User deleted with id : " + id;
        return msg;
    }

    @Override
    public User updateUser(int id, User user) {

        // get user from DB
        User userFromDb = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id : " + id));

        // update fields
        userFromDb.setName(user.getName());
        userFromDb.setEmail(user.getEmail());

        // save updated user
        User updatedUser = userRepository.save(userFromDb);

        return updatedUser;
    }
}
