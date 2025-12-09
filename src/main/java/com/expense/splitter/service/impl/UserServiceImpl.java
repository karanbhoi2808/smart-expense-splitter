package com.expense.splitter.service.impl;

import com.expense.splitter.dto.UserDto;
import com.expense.splitter.exception.DuplicateResourceException;
import com.expense.splitter.exception.ErrorCode;
import com.expense.splitter.exception.ResourceNotFoundException;
import com.expense.splitter.mapper.UserMapper;
import com.expense.splitter.model.User;
import com.expense.splitter.repository.UserRepository;
import com.expense.splitter.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @Override
    public UserDto createUser(UserDto userDto) {
        if (this.userRepository.existsByEmail(userDto.getEmail())) {
            throw new DuplicateResourceException(ErrorCode.EMAIL_ALREADY_EXISTS);
//            throw new EmailAlreadyExists();
        }
        User userEntity = this.userMapper.toModel(userDto);
        return this.userMapper.toDto(this.userRepository.save(userEntity));
    }

    @Override
    public UserDto updateUser(UUID id, UserDto userDto) {
        User existingUser = this.userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ErrorCode.USER_NOT_FOUND));
        existingUser.setName(userDto.getName());
        existingUser.setActive(userDto.isActive());
        return this.userMapper.toDto(this.userRepository.save(existingUser));
    }

    @Override
    public void deleteUser(UUID id) {
        User user = this.userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ErrorCode.USER_NOT_FOUND));

        this.userRepository.delete(user);
    }

    @Override
    public UserDto getUserById(UUID id) {
        return this.userMapper.toDto(this.userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ErrorCode.USER_NOT_FOUND)));
    }

    @Override
    public List<UserDto> getUsers() {
        return this.userRepository.findAll().stream().map(this.userMapper::toDto).toList();
    }

    @Override
    public void activeDeActiveUser(UUID id, boolean status) {
        User user = this.userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ErrorCode.USER_NOT_FOUND));
        user.setActive(status);
        this.userRepository.save(user);
    }
}
