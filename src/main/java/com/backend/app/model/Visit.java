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

    private String hour;

    //private String approbationCode;

    private Boolean status;

    @Column(name = "visit_type", nullable = false)
    private Boolean visitType;


    private String enterprise;

    //Aún no se cuenta con el scanner para la demo ,así que simularemos que el usuario
    //colocará su correo para la creación de citas y se validará mediante el dni en el robot

    //@Column(name = "qr_image", nullable = false, columnDefinition = "LONGTEXT")
    //private String qrImage;


    //@Column(name = "qr_visit_image", nullable = false, columnDefinition = "LONGTEXT")
    //private String qrVisitImage;

    @ManyToOne
    private Worker worker;

    @ManyToOne
    private Visitant visitant;

}
