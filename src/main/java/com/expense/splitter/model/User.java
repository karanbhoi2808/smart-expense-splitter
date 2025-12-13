package com.expense.splitter.model;

import com.expense.splitter.model.base.AuditModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class User extends AuditModel {

    @Column(nullable = false, length = 50)
    private String name;

    @Email
    @Column(unique = true, nullable = false)
    private String email;
}
