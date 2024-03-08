package com.backend.app.dto.create;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
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
    @NotNull(message = "Appointment date is mandatory")
    private Date appointmentDate;

    @NotBlank(message = "Hour is mandatory")
    private String appointmentHour;

    @NotNull(message = "Status is mandatory")
    private String status;

    @NotNull(message = "Visit type is mandatory")
    private Boolean visitType;

    private Integer workerId;

    @NotNull(message = "Visitant Id is mandatory")
    private Integer visitantId;

    @NotNull(message = "Enterprise Id is mandatory")
    private Integer enterpriseId;

}
