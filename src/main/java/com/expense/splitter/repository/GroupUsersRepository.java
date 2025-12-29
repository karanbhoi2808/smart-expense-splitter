package com.expense.splitter.repository;

import com.expense.splitter.model.GroupUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface GroupUsersRepository extends JpaRepository<GroupUser, UUID> {
    boolean existsByGroupIdAndUserId(UUID groupId, UUID userId);

    List<GroupUser> findByGroupId(UUID groupId);
}
