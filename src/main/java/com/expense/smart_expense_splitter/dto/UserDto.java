package com.expense.smart_expense_splitter.dto;

import com.expense.smart_expense_splitter.dto.base.BaseDto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.UniqueElements;

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
