package com.backend.app.dto.create;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VisitCreateDto {

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date approbationDate;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date appointmentDate;

    @NotBlank(message = "Hour is mandatory")
    private String hour;

    @NotBlank(message = "Approbation code is mandatory")
    private String approbationCode;

    @NotBlank(message = "Status is mandatory")
    private Boolean status;

    @NotBlank(message = "Visit type is mandatory")
    private Boolean visitType;

    private byte[] qrImage;

    private byte[] qrVisitImage;

    private Integer workerId;

    private Integer visitantId;

}
