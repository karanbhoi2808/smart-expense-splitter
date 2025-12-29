package com.expense.splitter.model;

import com.expense.splitter.model.base.AuditModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity(name = "group_users")
@Data
@EqualsAndHashCode(callSuper = true)
@Table(
        name = "group_users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"group_id", "user_id"})
        }
)
public class GroupUser extends AuditModel {

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
