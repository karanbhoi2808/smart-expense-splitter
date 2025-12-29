package com.expense.splitter.model;

import com.expense.splitter.model.base.AuditModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

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

    @OneToMany(mappedBy = "group") //be-directional to get the group->users
    private Set<GroupUser> groupUsers;
}
