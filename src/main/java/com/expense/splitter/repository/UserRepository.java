package com.expense.splitter.repository;

import com.expense.splitter.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    boolean findByEmail(String email);

    boolean existsByEmail(String email);
}
