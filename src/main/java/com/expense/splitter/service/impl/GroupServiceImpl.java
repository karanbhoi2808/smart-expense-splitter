package com.expense.splitter.service.impl;

import com.expense.splitter.dto.GroupDto;
import com.expense.splitter.dto.UserDto;
import com.expense.splitter.exception.ErrorCode;
import com.expense.splitter.exception.ResourceNotFoundException;
import com.expense.splitter.mapper.GroupMapper;
import com.expense.splitter.model.Group;
import com.expense.splitter.model.GroupUser;
import com.expense.splitter.model.User;
import com.expense.splitter.repository.GroupRepository;
import com.expense.splitter.repository.GroupUsersRepository;
import com.expense.splitter.service.GroupService;
import com.expense.splitter.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class GroupServiceImpl implements GroupService {
    private final GroupMapper groupMapper;
    private final GroupRepository groupRepository;
    private final GroupUsersRepository groupUsersRepository;
    private final UserService userService;

    GroupServiceImpl(GroupRepository groupRepository, GroupMapper groupMapper, GroupUsersRepository groupUsersRepository, UserService userService) {
        this.groupRepository = groupRepository;
        this.groupMapper = groupMapper;
        this.groupUsersRepository = groupUsersRepository;
        this.userService = userService;
    }

    @Override
    public GroupDto createGroup(GroupDto groupDto) {
        Group group = this.groupMapper.toModel(groupDto);
        this.groupRepository.save(group);
        return groupMapper.toDto(group);
    }

    @Override
    public GroupDto updateGroup(UUID id, GroupDto groupDto) {
        Group group = getGroupOrThrow(id);
        group.setTitle(groupDto.getTitle());
        group.setDescription(groupDto.getDescription());
        this.groupRepository.save(group);
        return groupMapper.toDto(group);
    }

    @Override
    public void deleteGroup(UUID id) {
        Group group = getGroupOrThrow(id);
        this.groupRepository.delete(group);
    }

    @Override
    public GroupDto getGroupById(UUID id) {
        Group group = getGroupOrThrow(id);
        return this.groupMapper.toDto(group);
    }

    @Override
    public List<GroupDto> getGroups() {
        return this.groupRepository.findAll().stream().map(this.groupMapper::toDto).toList();
    }

    @Override
    public void activeDeActiveGroup(UUID id, boolean status) {
        Group group = getGroupOrThrow(id);
        group.setActive(status);
        this.groupRepository.save(group);
    }


    @Override
    public void addUsersToGroup(UUID groupId, Set<UUID> userIds) {
        Group group = getGroupOrThrow(groupId);
        List<User> users = this.userService.getUsersByIds(userIds);
        List<User> remainingUser = users.stream()
                .filter(user ->
                        !this.groupUsersRepository.existsByGroupIdAndUserId(groupId, user.getId())
                )
                .toList();

        if (remainingUser.isEmpty()) return;

        List<GroupUser> groupUsers = remainingUser.stream().map(user -> {
            GroupUser groupUser = new GroupUser();
            groupUser.setGroup(group);
            groupUser.setUser(user);
            return groupUser;
        }).toList();

        this.groupUsersRepository.saveAll(groupUsers);
    }

    @Override
    public List<UserDto> getGroupWiseUsers(UUID groupId) {

        List<User> users = groupUsersRepository.findByGroupId(groupId)
                .stream()
                .map(GroupUser::getUser)
                .toList();
        return this.userService.toDtos(users);
    }


    private Group getGroupOrThrow(UUID id) {
        return groupRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(ErrorCode.GROUP_NOT_FOUND)
                );
    }

}
