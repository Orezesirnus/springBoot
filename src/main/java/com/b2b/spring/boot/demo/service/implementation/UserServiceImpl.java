package com.b2b.spring.boot.demo.service.implementation;

import com.b2b.spring.boot.demo.dto.UserRequest;
import com.b2b.spring.boot.demo.dto.UserResponse;
import com.b2b.spring.boot.demo.mapper.UserMapper;
import com.b2b.spring.boot.demo.repository.UserRepository;
import com.b2b.spring.boot.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
//@Transactional(readOnly = false) //rollbackFor = {Exception.class}
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;
    private final UserMapper userMapper;

    @Override
    public List<UserResponse> getAllUsers() {
        return this.userRepo.findAll().stream().map(u -> userMapper.toDto(u)).toList();
    }

    @Override
    public UserResponse getUserById(Long id) {
        return userRepo.findById(id).map(user -> userMapper.toDto(user)).orElse(null);
    }

    @Override
    public void createUser(UserRequest userRequest) {
        userRepo.save(userMapper.toEntity(userRequest));
    }

    @Override
    public void updateUser(Long id, UserRequest userRequest) {

        userRepo.save(userMapper.partialUpdate(userRepo.findById(id).get(), userRequest));
    }

    @Override
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }
}
