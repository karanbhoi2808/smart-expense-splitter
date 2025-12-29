package com.expense.splitter.service;

import com.expense.splitter.dto.UserDto;
import com.expense.splitter.model.User;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface UserService {
    UserDto createUser(UserDto userDto);

    UserDto updateUser(UUID id, UserDto userDto);

    void deleteUser(UUID id);

    UserDto getUserById(UUID id);

    List<UserDto> getUsers();

    void activeDeActiveUser(UUID id, boolean status);

    List<User> getUsersByIds(Set<UUID> ids);

//    List<UserDto> getUserDtosByIds(List<UUID> ids);

    List<UserDto> toDtos(List<User> users);
}
