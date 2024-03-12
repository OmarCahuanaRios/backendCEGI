package com.backend.app.dto.create;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CodeCreateDto {

    @NotNull(message = "code is required")
    private Integer code;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date creationHour;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date expirationHour;

    @NotNull(message = "isUsed is required")
    private boolean isUsed;

}
