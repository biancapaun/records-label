package com.recordslabel.labelapp.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "adrese_label")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Address {

    @Id
    @Column(name = "id_adrese")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "strada")
    private String strada;

    @Column(name = "localitate")
    private String localitate;

    @OneToOne(mappedBy = "address")
    @JsonBackReference
    private Label label;
}
