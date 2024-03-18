package com.backend.app.dto;

import lombok.*;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TemporalEmailDto {
    private Integer id;

    private String email;

}
