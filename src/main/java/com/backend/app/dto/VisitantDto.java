package com.backend.app.dto;

import com.backend.app.model.Auditable;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"id", "firstName", "lastName", "email", "documentId", "createdBy", "createdDate", "lastModifiedBy", "lastModifiedDate"})
public class VisitantDto extends Auditable<String> {

    private Integer id;

    private String firstName;

    private String lastName;

    private String email;

    private String documentId;

    private String documentType;

}
