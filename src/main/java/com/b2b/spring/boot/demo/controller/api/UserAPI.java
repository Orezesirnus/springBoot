package com.b2b.spring.boot.demo.controller.api;

import com.b2b.spring.boot.demo.dto.UserRequest;
import com.b2b.spring.boot.demo.dto.UserResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/users")
public interface UserAPI {

    @GetMapping(produces = "application/json")
    ResponseEntity<List<UserResponse>> getUsers(HttpServletRequest request);

    @GetMapping(value = "/{id}", produces = "application/json")
    ResponseEntity<UserResponse> getUser(HttpServletRequest request, @PathVariable Long id);

    @PostMapping(produces = "application/json", consumes = "application/json")
    ResponseEntity<?> createUser(HttpServletRequest request, @RequestBody UserRequest userRequest);

    @PutMapping(value = "/{id}", produces = "application/json", consumes = "application/json")
    ResponseEntity<?> updateUser(HttpServletRequest request, @PathVariable Long id, @RequestBody UserRequest userRequest);

    @DeleteMapping(value = "/{id}", produces = "application/json")
    ResponseEntity<?> deleteUser(HttpServletRequest request, @PathVariable Long id);
}
