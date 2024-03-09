package com.backend.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import java.util.List;

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

    @Transient
    private int workersNumber;

    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;

    @Column(nullable = false, name = "office_number")
    private String officeNumber;

    @OneToMany(mappedBy = "enterprise")
    @JsonIgnore
    private List<Worker> workerList;

    public int getWorkersNumber() {
        return workersNumber;
    }

    public void updateWorkerNumber() {
        this.workersNumber = workerList.size();
    }
}
