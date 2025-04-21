package com.recordslabel.labelapp.services;

import com.recordslabel.labelapp.dtos.ProductionDTO;
import com.recordslabel.labelapp.entities.Producer;
import com.recordslabel.labelapp.entities.Production;
import com.recordslabel.labelapp.exceptions.ResourceNotFoundException;
import com.recordslabel.labelapp.repositories.ProducerRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductionServiceImpl implements ProductionService {

    private static final Logger logger =  LoggerFactory.getLogger(ProductionServiceImpl.class);

    ProducerRepository producerRepository;
    ModelMapper modelMapper;

    public ProductionServiceImpl(ProducerRepository producerRepository, ModelMapper modelMapper) {
        this.producerRepository = producerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ProductionDTO> findProductionsByProducerId(Long id) {
        logger.info("Fetching productions for producer with ID: {}", id);
        Optional<Producer> producer = producerRepository.findById(id);
        if (!producer.isPresent()){
            logger.warn("Producer with id {} not found when fetching productions", id);
            throw new ResourceNotFoundException("Producer with id " + id + "not found");
        }
        List<ProductionDTO> productions =  producer.get().getProductions()
                .stream().map(production -> modelMapper.map(production, ProductionDTO.class))
                .toList();

        logger.debug("Found {} productions for producer ID {}", productions.size(), id);
        return productions;
    }

    @Override
    @Transactional
    public void createProductionForProducer(ProductionDTO productionDTO) {
        logger.info("Creating production '{}' for producer ID: {}", productionDTO.getProductionType(), productionDTO.getProducerId());

        Optional<Producer> producer = producerRepository.findById(productionDTO.getProducerId());
        if (!producer.isPresent()){
            logger.warn("Producer with id {} not found when creating production", productionDTO.getProducerId());
            throw new ResourceNotFoundException("Producer with id " + productionDTO.getProducerId() + "not found");
        }
        Production production = modelMapper.map(productionDTO, Production.class);
        production.setProducer(producer.get());

        logger.debug("Production '{}' saved successfully for producer ID: {}", production.getProductionType(), productionDTO.getProducerId());

    }
}
