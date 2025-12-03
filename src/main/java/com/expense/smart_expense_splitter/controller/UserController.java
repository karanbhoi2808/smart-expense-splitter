package com.expense.smart_expense_splitter.controller;

import com.expense.smart_expense_splitter.dto.UserDto;
import com.expense.smart_expense_splitter.model.User;
import com.expense.smart_expense_splitter.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
        UserDto createUser = userService.createUser(userDto);
        return new ResponseEntity<UserDto>(createUser, HttpStatus.CREATED);
    }

    //    updateUser
    //    deleteUser
    //    getUserById

    @GetMapping("")
    public List<UserDto> getUsers() {
        return this.userService.getUsers();
    }
}
