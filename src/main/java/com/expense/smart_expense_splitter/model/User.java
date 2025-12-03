package com.expense.smart_expense_splitter.model;

import com.expense.smart_expense_splitter.model.base.BaseModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;

@Entity(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class User extends BaseModel {

    @Column(nullable = false, length = 50)
    private String name;

    @Email
    @Column(unique = true, nullable = false)
    private String email;
}
