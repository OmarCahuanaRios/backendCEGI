package com.backend.app.dto.create;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WorkerCreateDto {

    @NotBlank(message = "First name is required")
    @Pattern(regexp = "^[a-zA-Z ]*$", message = "First name must be alphabetic")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Pattern(regexp = "^[a-zA-Z ]*$", message = "Last name must be alphabetic")
    private String lastName;

    @NotBlank(message = "Email is required")
    @Email
    private String email;

    @NotBlank(message = "Enterprise id is required")
    private Integer enterpriseId;
}
