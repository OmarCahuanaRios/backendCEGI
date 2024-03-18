package com.backend.app.dto.create;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateTemporalEmailDto {
    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is required")
    private String email;

}
