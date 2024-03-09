package com.backend.app.dto.create;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDto {

    @NotEmpty(message = "firstname is required")
    private String firstName;

    @NotEmpty(message = "lastname is required")
    private String lastName;

    @NotEmpty(message = "email is required")
    @Email
    private String email;

    @NotEmpty(message = "password is required")
    private String password;

    @NotEmpty(message = "enterprise is required")
    private String enterpriseName;
}
