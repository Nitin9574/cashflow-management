package com.qt.cashflow.controller;

import com.qt.cashflow.common.APIResponse;
import com.qt.cashflow.dto.LoginRequestDTO;
import com.qt.cashflow.dto.RegisterRequestDTO;


import com.qt.cashflow.entity.User;
import com.qt.cashflow.service.LoginService;

import com.qt.cashflow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserRegistrationController {

    @Autowired
    UserService userService;

//    @Autowired
//    private UserRegistration userRegistration;

    @Autowired
    private LoginService loginService;

    @PostMapping("/register")
    public APIResponse register(@RequestBody RegisterRequestDTO registerRequestDTO) {

        APIResponse apiResponse = loginService.register(registerRequestDTO);

        return  apiResponse;


    }

    @PostMapping("/login")
    public APIResponse login(@RequestBody LoginRequestDTO loginRequestDTO) {

        APIResponse apiResponse = loginService.login(loginRequestDTO);

        return  apiResponse;


    }

    @GetMapping("/all")
    public ResponseEntity<java.util.List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PutMapping("/{id}")
    public ResponseEntity<APIResponse> updateUser(@PathVariable Long id, @RequestBody User updateUserRequestDTO) {
        APIResponse apiResponse = new APIResponse();

        try {
            User updatedUser = userService.updateUser(id, updateUserRequestDTO);
            apiResponse.setMessage("User updated successfully");
            apiResponse.setData(updatedUser);
            return ResponseEntity.ok(apiResponse);
        } catch (IllegalArgumentException e) {
            apiResponse.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(apiResponse);
        }
    }




    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}


//    @GetMapping("/{id}")
//    public ResponseEntity<User> getUserById(@PathVariable Long id) {
//        User user = userService.getUserById(id);
//        return ResponseEntity.ok(user);
//    }
//

//
//    @PutMapping("/{id}")
//    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
//        userService.updateUser(id, user);
//        return ResponseEntity.ok(user);
//    }


//    @PostMapping("/register")
//    public ResponseEntity<User> registerUser(@RequestBody User user) {
//        User registeredUser = userService.registerUser(user);
//        return ResponseEntity.ok(registeredUser);
//        //        return userRegistration.registerUser(user, roles);
//    }