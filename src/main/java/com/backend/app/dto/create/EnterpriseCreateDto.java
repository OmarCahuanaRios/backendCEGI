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

    @NotBlank(message = "Business name is required")
    @Pattern(regexp = "^[a-zA-Z ]*$", message = "Business name must be alphabetic")
    private String businessName;

    @NotBlank(message = "Address is required")
    private String address;

    @NotBlank(message = "Email is required")
    @Email
    private String email;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^\\d{9}$", message = "Phone number must be 9 digits")
    private String phoneNumber;

    @NotBlank(message = "Country is required")
    private String country;

}
