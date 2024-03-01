package com.backend.app.dto.create;

import jakarta.validation.constraints.*;
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

    private Boolean status;

    @NotBlank(message = "Email is required")
    @Email
    private String email;

    @NotNull(message = "Enterprise name is required")
    private String enterprise;

    @NotBlank(message = "Document ID is required")
    @Pattern(regexp = "^\\d*$", message = "Document ID must be numeric")
    @Size(min = 8, max = 8, message = "Document ID must be 8 digits long")
    private String documentId;

    @NotBlank(message = "Document type is required")
    private String documentType;

}


