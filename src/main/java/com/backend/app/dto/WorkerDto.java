package com.backend.app.dto;

import com.backend.app.model.Auditable;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"id", "firstName", "lastName", "status", "email", "enterprise", "documentId", "documentType"
        , "createdBy", "createdDate", "lastModifiedBy", "lastModifiedDate"})
public class WorkerDto extends Auditable<String> {
    private Integer id;

    private String firstName;

    private String lastName;

    private Boolean status;

    private String email;

    private String enterprise;

    private String documentId;

    private String documentType;

    private String area;
    //private EnterpriseDto enterprise;
}
