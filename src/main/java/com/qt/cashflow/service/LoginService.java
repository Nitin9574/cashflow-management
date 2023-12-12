package com.qt.cashflow.service;

import com.qt.cashflow.dto.LoginRequestDTO;
import com.qt.cashflow.repository.UserRepository;

import com.qt.cashflow.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.qt.cashflow.common.APIResponse;
import com.qt.cashflow.dto.RegisterRequestDTO;
import com.qt.cashflow.entity.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtils jwtUtils;


    public APIResponse register(RegisterRequestDTO registerRequestDTO) {
        APIResponse apiResponse = new APIResponse();
        // Implement user registration logic, including validation
        // Example validation: Check if the username is already taken
        if (registerRequestDTO.getUsername() != null && !registerRequestDTO.getUsername().isEmpty()) {
           Boolean flag= userRepository.existsByUsername(registerRequestDTO.getUsername());
           if(flag) {
               apiResponse.setMessage("Username already taken.");
               return apiResponse;
           }
        }


        if (registerRequestDTO.getEmail() != null && !registerRequestDTO.getEmail().isEmpty()
                && userRepository.existsByEmail(registerRequestDTO.getEmail())) {
            apiResponse.setMessage("Email is already taken. Try with a different email.");
            return apiResponse;
        }

        User user = new User();
        user.setUsername(registerRequestDTO.getUsername());
        user.setEmail(registerRequestDTO.getEmail());
        user.setAge(registerRequestDTO.getAge());
        user.setDoj(registerRequestDTO.getDoj());
        user.setPassword(registerRequestDTO.getPassword());
        user.setMiddleName(registerRequestDTO.getMiddleName());
        user.setFirstName(registerRequestDTO.getFirstName());
        user.setLastName(registerRequestDTO.getLastName());
        user.setJob(registerRequestDTO.getJob());
        user.setMobileNumber(registerRequestDTO.getMobileNumber());
        user.setRoles(registerRequestDTO.getRoles());


        // Save the user to the repository

        userRepository.save(user);

//        String token = jwtUtils.generateJwt(user);
//
//        Map<String, Object> data = new HashMap<>();
//        data.put("access token", token);
//
//        apiResponse.setData(data);

        apiResponse.setMessage("User registered successfully");

        return apiResponse;
        }


    public APIResponse login(LoginRequestDTO loginRequestDTO) {

        APIResponse apiResponse = new APIResponse();

        User user = userRepository.findOneByUsernameIgnoreCaseAndPassword(loginRequestDTO.getUsername(), loginRequestDTO.getPassword());

        if(user == null){
            apiResponse.setData("User Login Failed");
            return apiResponse;
        }
          else {
            apiResponse.setData("User Logged IN");
        }
        //jwt generate token
        String token = jwtUtils.generateJwt(user);


        Map<String, Object> data = new HashMap<>();
        data.put("access token", token);


        apiResponse.setData(data);

        return apiResponse;
    }
}
