package com.recordslabel.labelapp.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "contract")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Contract {

    @Id
    @Column(name="id_contract")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="data_start")
    private LocalDate startDate;

    @Column(name="data_incheiere")
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name="id_artist")
    private Artist artist;

    @ManyToOne
    @JoinColumn(name="id_label")
    private Label label;

}

