package com.backend.app.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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

    private String appointmentHour;

    private String status;

    @Column(name = "visit_type", nullable = false)
    private Boolean visitType;

    @ManyToOne
    @JoinColumn(name = "enterprise_id")
    private Enterprise enterprise;

    @ManyToOne
    @JoinColumn(name = "worker_id")
    private Worker worker;

    @ManyToOne
    private Visitant visitant;

}
