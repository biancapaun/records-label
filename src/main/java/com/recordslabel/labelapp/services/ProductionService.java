package com.recordslabel.labelapp.services;

import com.recordslabel.labelapp.dtos.ProductionDTO;

import java.util.List;

public interface ProductionService {

    List<ProductionDTO> findProductionsByProducerId(Long id);
    void createProductionForProducer(ProductionDTO productionDTO);
}
