package com.recordslabel.labelapp.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrizeDTO {

    private long id;

    private String name;

    private String category;

    private String year;
}
