package com.recordslabel.labelapp.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "premiu")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Prize {

    @Id
    @Column(name="id_premiu")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nume")
    private String name;

    @Column(name="categorie")
    private String category;

    @Column(name="an")
    private String year;

    @ManyToOne
    @JoinColumn(name = "id_artist")
    private Artist artist;


}
