package com.backend.app.dto;

import com.backend.app.model.Auditable;
import com.backend.app.model.Enterprise;
import com.backend.app.model.Visitant;
import com.backend.app.model.Worker;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
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
@JsonPropertyOrder({"id", "approbationDate", "appointmentDate", "hour", "approbationCode", "status", "visitType", "qrImage", "enterprise",
        "qrVisitImage", "worker", "visitant", "createdBy", "createdDate", "lastModifiedBy", "lastModifiedDate"})
public class VisitDto extends Auditable<String> {

    private Integer id;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date approbationDate;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date appointmentDate;

    private String appointmentHour;

    private String status;

    private Boolean visitType;

    private Visitant visitant;


}
