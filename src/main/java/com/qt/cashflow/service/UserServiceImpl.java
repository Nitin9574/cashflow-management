package com.qt.cashflow.service;


import com.qt.cashflow.entity.Role;
import com.qt.cashflow.entity.User;
import com.qt.cashflow.repository.RoleRepository;
import com.qt.cashflow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public User registerUser(User user, Set<String> roleNames) {
        Set<Role> roles = new HashSet<>();

        User registeredUser = userRepository.save(user);
        return registeredUser;
   }

    @Override
    public User loginUser(String username, String password) {
        return null;
    }



    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(Long id, User user) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));


        existingUser.setEmail(user.getEmail());
        existingUser.setAge(user.getAge());

        userRepository.save(existingUser);

        return existingUser;
    }



    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new IllegalArgumentException("User not found");
        }
        userRepository.deleteById(id);
    }
}






//    @Override
//    public User loginUser(String username, String password) {
//        // Implement user login logic, including authentication
//        // Return the logged-in user
//    }



























//    @Override
//    public User getUserById(Long id) {
//        return userRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("User not found"));
//    }
//
//    @Override
//    public List<User> getAllUsers() {
//        return userRepository.findAll();
//    }
//






































//@Service
//public class UserServiceImpl implements UserService {
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    public List<User> getAllUsers() {
//        return userRepository.findAll();
//    }
//
//
//
//    @Override
//    public User createUser(User user) {
//        return userRepository.save(user);
//    }
//














    //    @Override
//    public User getUserById(Long id) {
//        return userRepository.findById(id).orElse(null);
//    }
//    @Override
//    public User updateUser(Long id, User user) {
//        if (userRepository.existsById(id)) {
//            user.setId(id);
//            return userRepository.save(user);
//        } else {
//            return null; // Handle the case where the user with the given id doesn't exist.
//        }
//    }
//
//    @Override
//    public void deleteUser(Long id) {
//        userRepository.deleteById(id);
//    }


