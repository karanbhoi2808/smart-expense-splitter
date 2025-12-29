package com.expense.splitter.service;


import com.expense.splitter.dto.GroupDto;
import com.expense.splitter.dto.UserDto;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface GroupService {
    GroupDto createGroup(GroupDto groupDto);

    GroupDto updateGroup(UUID id, GroupDto groupDto);

    void deleteGroup(UUID id);

    GroupDto getGroupById(UUID id);

    List<GroupDto> getGroups();

    void activeDeActiveGroup(UUID id, boolean status);

    void addUsersToGroup(UUID groupId, Set<UUID> userIds);

    List<UserDto> getGroupWiseUsers(UUID groupId);
}
