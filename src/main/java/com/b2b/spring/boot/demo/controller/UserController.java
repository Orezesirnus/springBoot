package com.b2b.spring.boot.demo.controller;

import com.b2b.spring.boot.demo.controller.api.UserAPI;
import com.b2b.spring.boot.demo.dto.UserRequest;
import com.b2b.spring.boot.demo.dto.UserResponse;
import com.b2b.spring.boot.demo.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController implements UserAPI {

    private final UserService userService;

    @Override
    public ResponseEntity<List<UserResponse>> getUsers(HttpServletRequest request) {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserResponse> getUser(HttpServletRequest request, Long id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> createUser(HttpServletRequest request, UserRequest userRequest) {
        userService.createUser(userRequest);
        return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> updateUser(HttpServletRequest request, Long id, UserRequest userRequest) {
        userService.updateUser(id, userRequest);
        return new ResponseEntity<>( "Edited", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> deleteUser(HttpServletRequest request, Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }


}
