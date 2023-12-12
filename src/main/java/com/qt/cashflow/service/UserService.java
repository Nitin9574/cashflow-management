package com.qt.cashflow.service;


import com.qt.cashflow.entity.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    User registerUser(User user, Set<String> roles);
    User loginUser(String username, String password);

    User updateUser(Long id, User user);

    void deleteUser(Long id);


    List<User> getAllUsers();
}



















































































//    User getUserById(Long id);
//    List<User> getAllUsers();
//    void updateUser(Long id, User user);


//    User getUserById(Long id);
//    User updateUser(Long id, User user);
//    void deleteUser(Long id);