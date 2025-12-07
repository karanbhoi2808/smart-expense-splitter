package com.expense.splitter.dto;

import com.expense.splitter.dto.base.BaseDto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
//@ToString(callSuper = true)
public class UserDto extends BaseDto {
    @NotNull(message = "Name can't be empty.")
    @Size(max = 50)
    private String name;

    @NotNull(message = "Email can't be empty.")
    @Email(message = "Invalid email formate.")
    private String email;
}
