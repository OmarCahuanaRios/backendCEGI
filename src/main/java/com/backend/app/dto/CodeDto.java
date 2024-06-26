package com.backend.app.dto;

import com.backend.app.model.Visitant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CodeDto {

    private Integer id;

    private Integer code;

    private Date creationHour;

    private Date expirationHour;

    private boolean used;

    private Visitant visitant;

}
