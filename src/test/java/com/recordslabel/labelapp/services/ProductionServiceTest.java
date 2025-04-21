package com.recordslabel.labelapp.services;

import com.recordslabel.labelapp.dtos.ProductionDTO;
import com.recordslabel.labelapp.entities.Producer;
import com.recordslabel.labelapp.entities.Production;
import com.recordslabel.labelapp.repositories.ProducerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductionServiceTest {

    @Mock
    ProducerRepository producerRepository;

    @Mock
    ModelMapper modelMapper;

    @InjectMocks
    ProductionServiceImpl productionService;

    @Test
    void testFindProductions_whenProducerExists_shouldReturnProductionDTO() {
        // given
        Long producerId = 1L;
        Producer producer = new Producer();
        producer.setId(producerId);

        Production production = new Production();
        production.setProductionType("Studio Album");
        List<Production> productions = List.of(production);

        producer.setProductions(productions);

        ProductionDTO productionDTO = new ProductionDTO();
        productionDTO.setProductionType("Studio Album");

        when(producerRepository.findById(producerId)).thenReturn(Optional.of(producer));
        when(modelMapper.map(production, ProductionDTO.class)).thenReturn(productionDTO);

        // when
        List<ProductionDTO> result = productionService.findProductionsByProducerId(producerId);

        // then
        assertEquals(1, result.size());
        assertEquals("Studio Album", result.get(0).getProductionType());
        verify(producerRepository).findById(producerId);
        verify(modelMapper).map(production, ProductionDTO.class);
    }

    @Test
    void testCreateProduction_whenProducerExists_shouldMapAndSave() {
        // given
        Long producerId = 1L;
        ProductionDTO dto = new ProductionDTO();
        dto.setProducerId(producerId);
        dto.setProductionType("Studio Album");

        Producer producer = new Producer();
        producer.setId(producerId);

        Production production = new Production();
        production.setProductionType("Studio Album");

        when(producerRepository.findById(producerId)).thenReturn(Optional.of(producer));
        when(modelMapper.map(dto, Production.class)).thenReturn(production);

        // when
        productionService.createProductionForProducer(dto);

        // then
        assertEquals(producer, production.getProducer());
        verify(producerRepository).findById(producerId);
        verify(modelMapper).map(dto, Production.class);
    }


}
