package com.expense.splitter.dto.base;

import com.expense.splitter.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AuditDto extends BaseDto {
    private User createdBy;
    private User updatedBy;
}
