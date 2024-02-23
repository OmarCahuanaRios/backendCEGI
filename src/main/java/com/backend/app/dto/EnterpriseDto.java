package com.backend.app.dto;

import com.backend.app.model.Auditable;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"id", "businessName", "address", "email", "phoneNumber", "country", "createdBy", "createdDate", "lastModifiedBy", "lastModifiedDate"})
public class EnterpriseDto extends Auditable<String> {

    private Integer id;

    private String businessName;

    private String address;

    private String email;

    private String phoneNumber;

    private String country;

}
