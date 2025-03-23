package com.nt.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "REST_POLITICIAN_INFO")
@AllArgsConstructor
@NoArgsConstructor
public class Politician {

    @Id
    @SequenceGenerator(name = "gen1", sequenceName = "PID_SEQ1", initialValue = 100, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen1")
    private Integer pid;

    @Column(length = 30)//, nullable = false, unique = true) // Ensuring unique names
    private String pname;

    @Column(length = 50)//, nullable = false)
    private String paddress;

    @Column(length = 30)//, nullable = false)
    private String party;

    //@Column(nullable = false)
    private LocalDate pdob;

    //@Column(nullable = false)
    private LocalDateTime ptob; // Replacing LocalTime for timestamp
}
