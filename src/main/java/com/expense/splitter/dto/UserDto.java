package com.expense.splitter.dto;

import com.expense.splitter.dto.base.BaseDto;
import jakarta.validation.constraints.Email;
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
//@ToString(callSuper = true)
public class UserDto extends BaseDto {
    @NotBlank
    @Size(max = 50)
    private String name;

    //    @NotNull // allows the empty(DB as well)
    @NotBlank
    @Email
    private String email;
    //To check that email is existed we need custom annotation here Future scope
}
