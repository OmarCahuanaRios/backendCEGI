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
@JsonPropertyOrder({"id", "businessName", "address", "phoneNumber", "createdBy", "createdDate", "lastModifiedBy", "lastModifiedDate"})
public class EnterpriseDto extends Auditable<String> {

    private Integer id;

    private String enterpriseName;

    private String officeNumber;

    private String phoneNumber;

    private Integer workersNumber;

}
