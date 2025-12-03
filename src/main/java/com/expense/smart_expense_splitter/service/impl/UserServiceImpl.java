package com.expense.smart_expense_splitter.service.impl;

import com.expense.smart_expense_splitter.dto.UserDto;
import com.expense.smart_expense_splitter.mapper.UserMapper;
import com.expense.smart_expense_splitter.model.User;
import com.expense.smart_expense_splitter.repository.UserRepository;
import com.expense.smart_expense_splitter.service.UserService;
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
        User userEntity = this.userMapper.toModel(userDto);
        return this.userMapper.toDto(this.userRepository.save(userEntity));
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        return null;
    }

    @Override
    public void deleteUser(UUID id) {

    }

    @Override
    public UserDto getUserById(UUID id) {
        return null;
    }

    @Override
    public List<UserDto> getUsers() {
        return this.userRepository.findAll().stream().map(this.userMapper::toDto).toList();
    }
}
