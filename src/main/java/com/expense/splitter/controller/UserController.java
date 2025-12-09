package com.expense.splitter.controller;

import com.expense.splitter.dto.StatusRequest;
import com.expense.splitter.dto.UserDto;
import com.expense.splitter.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @PutMapping("{userId}")
    public ResponseEntity<UserDto> updateUser(@PathVariable UUID userId, @Valid @RequestBody UserDto userDto) {
        UserDto updateUser = userService.updateUser(userId, userDto);
        return new ResponseEntity<UserDto>(updateUser, HttpStatus.CREATED);
    }

    @DeleteMapping("{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID userId) {
        this.userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{userId}")
    public UserDto getUserById(@PathVariable UUID userId) {
        return this.userService.getUserById(userId);
    }

    @GetMapping("")
    public List<UserDto> getUsers() {
        return this.userService.getUsers();
    }

    @PatchMapping("{userId}")
    public ResponseEntity<Void> activeDeActiveUser(@PathVariable UUID userId, @Valid @RequestBody StatusRequest statusRequest) {
        this.userService.activeDeActiveUser(userId, statusRequest.getStatus());
        return ResponseEntity.noContent().build();
    }
}
