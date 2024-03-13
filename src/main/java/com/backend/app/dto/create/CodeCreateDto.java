package com.backend.app.dto.create;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    private Integer code;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private Date creationHour;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private Date expirationHour;

    private boolean isUsed;

    private Integer visitantId;

}
