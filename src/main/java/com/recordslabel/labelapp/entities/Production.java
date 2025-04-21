package com.recordslabel.labelapp.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Entity
@Table(name = "productie")
@IdClass(ProductionId.class)
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Production {

    @Column(name="tip_productie")
    private String productionType;

    @Column(name="buget")
    private BigDecimal budget;

    @Id
    @ManyToOne
    @JoinColumn(name="id_album")
    private Album album;

    @Id
    @ManyToOne
    @JoinColumn(name="id_producator")
    private Producer producer;


}
