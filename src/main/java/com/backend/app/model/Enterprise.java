package com.backend.app.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "enterprise_name", nullable = false, unique = true)
    private String enterpriseName;

    @Column(nullable = false, name = "workers_number")
    private Integer workersNumber;

    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;

    @Column(nullable = false, name = "office_number")
    private String officeNumber;

}
