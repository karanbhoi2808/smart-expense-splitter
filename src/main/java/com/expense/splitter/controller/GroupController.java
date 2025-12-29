package com.expense.splitter.controller;

import com.expense.splitter.dto.GroupDto;
import com.expense.splitter.dto.StatusRequest;
import com.expense.splitter.dto.UserDto;
import com.expense.splitter.service.GroupService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping(value = "groups")
public class GroupController {
    GroupService groupService;

    GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping
    public ResponseEntity<GroupDto> createGroup(@RequestBody GroupDto groupDto) {
        GroupDto groupDto1 = this.groupService.createGroup(groupDto);
        return new ResponseEntity<>(groupDto1, HttpStatus.CREATED);
    }

    @PutMapping("{groupId}")
    public ResponseEntity<GroupDto> updateGroup(@PathVariable UUID groupId, @Valid @RequestBody GroupDto groupDto) {
        GroupDto groupDto1 = this.groupService.updateGroup(groupId, groupDto);
        return new ResponseEntity<>(groupDto1, HttpStatus.OK);
    }

    @GetMapping
    public List<GroupDto> getAllGroups() {
        return this.groupService.getGroups();
    }

    @GetMapping("{groupId}")
    public GroupDto getGroupById(@PathVariable UUID groupId) {
        return this.groupService.getGroupById(groupId);
    }

    @DeleteMapping("{groupId}")
    public ResponseEntity<Void> deleteGroup(@PathVariable UUID groupId) {
        this.groupService.deleteGroup(groupId);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("{groupId}")
    public ResponseEntity<Void> activeDeActiveGroup(@PathVariable UUID groupId, @Valid @RequestBody StatusRequest statusRequest) {
        this.groupService.activeDeActiveGroup(groupId, statusRequest.getStatus());
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{groupId}/users")
    public ResponseEntity<Void> addUsersToGroup(@PathVariable UUID groupId, @RequestBody Set<UUID> userIds) {
        this.groupService.addUsersToGroup(groupId, userIds);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{groupId}/users")
    public ResponseEntity<List<UserDto>> getGroupWiseUsers(@PathVariable UUID groupId) {
        List<UserDto> groupWiseUsers = this.groupService.getGroupWiseUsers(groupId);
        return new ResponseEntity<>(groupWiseUsers, HttpStatus.OK);
    }
}
