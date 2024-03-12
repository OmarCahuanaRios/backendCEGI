package com.backend.app.model;

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
@Table(name = "codes")
@Audited
public class Code {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer code;

    @Column(name = "creationHour", nullable = false)
    private Date creationHour;

    @Column(name = "expirationHour", nullable = false)
    private Date expirationHour;

    @Column(name = "isUsed", nullable = false)
    private boolean isUsed;


}
