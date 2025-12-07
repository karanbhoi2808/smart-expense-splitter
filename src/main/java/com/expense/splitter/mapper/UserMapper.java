package com.expense.splitter.mapper;

import com.expense.splitter.dto.UserDto;
import com.expense.splitter.mapper.base.BaseMapper;
import com.expense.splitter.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements BaseMapper<User, UserDto> {
    @Override
    public UserDto toDto(User model) {
        UserDto userDto = new UserDto();
        userDto.setId(model.getId());
        userDto.setName(model.getName());
        userDto.setEmail(model.getEmail());
        userDto.setCreatedAt(model.getCreatedAt());
        userDto.setUpdatedAt(model.getUpdatedAt());
        userDto.setActive(model.isActive());
        return userDto;
    }

    @Override
    public User toModel(UserDto dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setActive(dto.isActive());
        return user;
    }
}
