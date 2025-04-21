package com.recordslabel.labelapp.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "producator")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Producer {

    @Id
    @Column(name="id_producator")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nume")
    private String name;

    @Column(name="specializare")
    private String specialization;

    @Column(name="tara_origine")
    private String originCountry;

    @OneToMany(mappedBy = "producer")
    private List<Production> productions;

}
