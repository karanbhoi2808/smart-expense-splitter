package com.expense.splitter.service.impl;

import com.expense.splitter.dto.GroupDto;
import com.expense.splitter.exception.ErrorCode;
import com.expense.splitter.exception.ResourceNotFoundException;
import com.expense.splitter.mapper.GroupMapper;
import com.expense.splitter.model.Group;
import com.expense.splitter.repository.GroupRepository;
import com.expense.splitter.service.GroupService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GroupServiceImpl implements GroupService {
    private final GroupMapper groupMapper;
    private final GroupRepository groupRepository;

    GroupServiceImpl(GroupRepository groupRepository, GroupMapper groupMapper) {
        this.groupRepository = groupRepository;
        this.groupMapper = groupMapper;
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

    private Group getGroupOrThrow(UUID id) {
        return groupRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(ErrorCode.GROUP_NOT_FOUND)
                );
    }
}
