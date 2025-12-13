package com.expense.splitter.mapper;

import com.expense.splitter.dto.GroupDto;
import com.expense.splitter.mapper.base.BaseMapper;
import com.expense.splitter.model.Group;
import org.springframework.stereotype.Component;

@Component
public class GroupMapper implements BaseMapper<Group, GroupDto> {
    @Override
    public GroupDto toDto(Group model) {
        GroupDto groupDto = new GroupDto();
        groupDto.setId(model.getId());
        groupDto.setTitle(model.getTitle());
        groupDto.setDescription(model.getDescription());
        groupDto.setActive(model.isActive());
        groupDto.setCreatedAt(model.getCreatedAt());
        groupDto.setUpdatedAt(model.getUpdatedAt());
        groupDto.setCreatedBy(model.getCreatedBy());
        groupDto.setUpdatedBy(model.getUpdatedBy());
        return groupDto;
    }

    @Override
    public Group toModel(GroupDto dto) {
        Group group = new Group();
        group.setTitle(dto.getTitle());
        group.setDescription(dto.getDescription());
        group.setActive(dto.isActive());
        return group;
    }
}
