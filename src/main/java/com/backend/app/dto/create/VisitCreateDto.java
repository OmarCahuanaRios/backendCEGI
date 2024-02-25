package com.backend.app.dto.create;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
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
public class VisitCreateDto {

    @JsonFormat(pattern = "dd-MM-yyyy")
    @NotNull(message = "Approbation date is mandatory")
    private Date approbationDate;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @NotNull(message = "Appointment date is mandatory")
    private Date appointmentDate;

    @NotBlank(message = "Hour is mandatory")
    private String hour;

    @NotBlank(message = "Approbation code is mandatory")
    private String approbationCode;

    @NotNull(message = "Status is mandatory")
    private Boolean status;

    @NotNull(message = "Visit type is mandatory")
    private Boolean visitType;

    @NotBlank(message = "QR image is mandatory")
    private String qrImage;

    @NotBlank(message = "QR visit image is mandatory")
    private String qrVisitImage;

    @NotNull(message = "Worker id is mandatory")
    private Integer workerId;

    @NotNull(message = "Visitant id is mandatory")
    private Integer visitantId;

}
