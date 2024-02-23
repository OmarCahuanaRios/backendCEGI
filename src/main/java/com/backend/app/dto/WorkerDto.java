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
public class WorkerDto extends Auditable<String> {
    private Integer id;

    private String firstName;

    private String lastName;

    private String email;

    private EnterpriseDto enterprise;
}
