package com.b2b.spring.boot.demo.service;

import com.b2b.spring.boot.demo.dto.UserRequest;
import com.b2b.spring.boot.demo.dto.UserResponse;
import com.b2b.spring.boot.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<UserResponse> getAllUsers();
    UserResponse getUserById(Long id);
    void createUser(UserRequest userRequest);
    void updateUser(Long id, UserRequest userRequest);
    void deleteUser(Long id);
}
