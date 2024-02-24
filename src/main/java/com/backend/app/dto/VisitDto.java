package com.backend.app.dto;

import com.backend.app.model.Auditable;
import com.backend.app.model.Visitant;
import com.backend.app.model.Worker;
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
public class VisitDto extends Auditable<String> {

    private Integer id;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date approbationDate;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date appointmentDate;

    private String hour;

    private String approbationCode;

    private Boolean status;

    private Boolean visitType;

    private byte[] qrImage;

    private byte[] qrVisitImage;

    private Worker worker;

    private Visitant visitant;

}
