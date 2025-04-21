package com.recordslabel.labelapp.entities;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ProductionId implements Serializable {

    private Long album;

    private Long producer;

}
