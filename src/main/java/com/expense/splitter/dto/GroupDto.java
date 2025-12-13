package com.expense.splitter.dto;

import com.expense.splitter.dto.base.AuditDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class GroupDto extends AuditDto {

    @NotBlank
    @Size(max = 100)
    private String title;

    @Size(max = 1000)
    private String description;
}
