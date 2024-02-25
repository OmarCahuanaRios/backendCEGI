package com.backend.app.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import java.util.Date;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "visits")
@Audited
@AuditTable(value = "aud_visit")
public class Visit extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date approbationDate;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date appointmentDate;

    private String hour;

    private String approbationCode;

    private Boolean status;

    @Column(name = "visit_type", nullable = false)
    private Boolean visitType;

    private String qrImage;

    private String qrVisitImage;

    @OneToOne
    private Worker worker;

    @OneToOne
    private Visitant visitant;

}
