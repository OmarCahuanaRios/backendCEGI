package com.backend.app.dto;

import com.backend.app.model.Auditable;
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
@JsonPropertyOrder({"id", "approbationDate", "appointmentDate", "hour", "approbationCode", "status", "visitType", "qrImage",
        "qrVisitImage", "worker", "visitant", "createdBy", "createdDate", "lastModifiedBy", "lastModifiedDate"})
public class VisitDto extends Auditable<String> {

    private Integer id;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date approbationDate;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date appointmentDate;

    private String hour;


    private String enterprise;

    //private String approbationCode;

    private Boolean status;

    private Boolean visitType;


    //Aún no se cuenta con el scanner para la demo ,así que simularemos que el usuario
    //colocará su correo para la creación de citas y se validará mediante el dni en el robot

    //private String qrImage;

    //private String qrVisitImage;

    private Worker worker;

    private Visitant visitant;

}
