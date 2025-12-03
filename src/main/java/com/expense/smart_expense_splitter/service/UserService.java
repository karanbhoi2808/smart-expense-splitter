package com.expense.smart_expense_splitter.service;

import com.expense.smart_expense_splitter.dto.UserDto;
import com.expense.smart_expense_splitter.model.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    UserDto createUser(UserDto userDto);

    UserDto updateUser(UserDto userDto);

    void deleteUser(UUID id);

    UserDto getUserById(UUID id);

    List<UserDto> getUsers();
}
