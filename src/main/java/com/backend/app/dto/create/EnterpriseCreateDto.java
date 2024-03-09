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
public class EnterpriseCreateDto {

    @NotBlank(message = "Enterprise name is required")
    @Pattern(regexp = "^[a-zA-Z ]*$", message = "Business name must be alphabetic")
    private String enterpriseName;

    @NotBlank(message = "Office number is required")
    private String officeNumber;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^\\d{9}$", message = "Phone number must be 9 digits")
    private String phoneNumber;




}
