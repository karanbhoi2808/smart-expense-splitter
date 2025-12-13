package com.expense.splitter.model;

import com.expense.splitter.model.base.AuditModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity(name = "groups")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Group extends AuditModel {

    @Column(length = 100, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", length = 1000)
    private String description;
}
