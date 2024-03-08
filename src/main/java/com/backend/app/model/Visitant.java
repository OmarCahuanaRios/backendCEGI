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
@Table(name = "visitants")
@Audited
@AuditTable(value = "aud_visitant")
public class Visitant extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name= "email", nullable = false, unique = true)
    private String email;

    @Column(name = "document_id", nullable = false, unique = true)
    private String documentId;

    @Column(name = "document_type", nullable = false)
    private String documentType;

    @ManyToOne
    @JoinColumn(name = "enterprise_id", nullable = false)
    private Enterprise enterprise;
}
