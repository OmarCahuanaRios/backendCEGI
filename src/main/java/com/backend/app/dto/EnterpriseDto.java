package com.backend.app.dto;

import com.backend.app.model.Auditable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnterpriseDto extends Auditable<String> {
    private Integer id;

    private String businessName;

    private String address;

    private String email;

    private String phoneNumber;

    private String country;

}
