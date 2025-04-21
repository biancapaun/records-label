package com.recordslabel.labelapp.services;

import com.recordslabel.labelapp.dtos.PrizeDTO;

import java.util.List;

public interface PrizeService {

    long findAllPrizes();
    List<PrizeDTO> findPrizesById(Long id);
}
