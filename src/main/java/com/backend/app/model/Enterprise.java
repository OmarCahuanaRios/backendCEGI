package com.backend.app.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import java.util.Date;
import java.util.UUID;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "enterprises")
@Audited
@AuditTable(value = "aud_enterprises")
public class Enterprise extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Integer id;

    @Column(name = "business_name", nullable = false, unique = true)
    private String businessName;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;

    @Column(nullable = false)
    private String country;

}
