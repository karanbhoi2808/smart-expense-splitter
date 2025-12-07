package com.expense.splitter.service;

import com.expense.splitter.dto.UserDto;

import java.util.List;
import java.util.UUID;

public interface UserService {
    UserDto createUser(UserDto userDto);

    UserDto updateUser(UserDto userDto);

    void deleteUser(UUID id);

    UserDto getUserById(UUID id);

    List<UserDto> getUsers();
}
