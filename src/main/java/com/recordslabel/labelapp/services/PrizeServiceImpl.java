package com.recordslabel.labelapp.services;

import com.recordslabel.labelapp.dtos.PrizeDTO;
import com.recordslabel.labelapp.entities.Artist;
import com.recordslabel.labelapp.exceptions.ResourceNotFoundException;
import com.recordslabel.labelapp.repositories.ArtistRepository;
import com.recordslabel.labelapp.repositories.PrizeRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrizeServiceImpl implements PrizeService {

    private static final Logger logger =  LoggerFactory.getLogger(PrizeServiceImpl.class);

    PrizeRepository prizeRepository;
    ArtistRepository artistRepository;

    ModelMapper modelMapper;

    public PrizeServiceImpl(ArtistRepository artistRepository, PrizeRepository prizeRepository, ModelMapper modelMapper){
        this.artistRepository = artistRepository;
        this.prizeRepository = prizeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public long findAllPrizes() {
        return prizeRepository.count();
    }

    public List<PrizeDTO> findPrizesById(Long id) {
        logger.info("Finding prizes for artist ID: {}",id);

        Optional<Artist> artist = artistRepository.findById(id);
        if (!artist.isPresent()) {
            logger.warn("Artist with id {} not found", id);
            throw new ResourceNotFoundException("Artist with id " + id + " not found");
        }
        List<PrizeDTO> prizes =  artist.get().getPrizes()
                .stream().map(prize -> modelMapper.map(prize, PrizeDTO.class))
                .toList();
        logger.debug("Found {} prizes for artist ID {}", prizes.size(), id);
        return prizes;
    }

}
