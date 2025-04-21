package com.recordslabel.labelapp.services;

import com.recordslabel.labelapp.dtos.ArtistDTO;
import com.recordslabel.labelapp.entities.Artist;
import com.recordslabel.labelapp.exceptions.ResourceNotFoundException;
import com.recordslabel.labelapp.repositories.ArtistRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArtistServiceImpl implements ArtistService{

    private static final Logger logger =  LoggerFactory.getLogger(ArtistServiceImpl.class);


    ArtistRepository artistRepository;

    ModelMapper modelMapper;

    public ArtistServiceImpl(ArtistRepository artistRepository, ModelMapper modelMapper){
        this.artistRepository = artistRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ArtistDTO> findAllArtists() {
        logger.info("Fetching all artists");
        List<ArtistDTO> artists =  artistRepository.findAllByOrderByIdAsc()
                        .stream().map(artist -> modelMapper.map(artist, ArtistDTO.class))
                        .toList();
        logger.debug("Found {} artists", artists.size());
        return artists;
    }

    @Override
    public ArtistDTO findArtistById(Long id) {
        logger.info("Searching for artist with ID: {}", id);
        Optional<Artist> artistOptional = artistRepository.findById(id);
        if (!artistOptional.isPresent()) {
            logger.warn("Artist with id {} not found", id);
            throw new ResourceNotFoundException("Artist with id " + id + " not found");
        }

        logger.debug("Artist found: {}", artistOptional.get().getSceneName());
        return modelMapper.map(artistOptional.get(), ArtistDTO.class);
    }

    @Override
    @Transactional
    public void createArtist(ArtistDTO artistDTO) {
        logger.info("Creating new artist: {}", artistDTO.getSceneName());
        Artist artistEntity = modelMapper.map(artistDTO, Artist.class);
        artistRepository.save(artistEntity);
        logger.debug("Artist saved with ID: {}", artistEntity.getId());
    }

    @Override
    @Transactional
    public void updateArtist(Long id, ArtistDTO artistDTO) {
        logger.info("Updating artist with ID: {}", id);
        Optional<Artist> artistEntity = artistRepository.findById(id);
        if (!artistEntity.isPresent()){
            logger.warn("Artist with id {} not found for update", id);
            throw new ResourceNotFoundException("Artist with id " + id + " not found");
        }
        modelMapper.map(artistDTO, artistEntity.get());
        artistRepository.save(artistEntity.get());
        logger.info("Artist with ID: {} updated successfully", id);
    }


    @Override
    public void deleteArtistById(Long id) {
        logger.info("Deleting artist with ID: {}", id);
        artistRepository.deleteById(id);
        logger.info("Artist with ID: {} deleted", id);
    }

    public List<ArtistDTO> findAllArtistsSortedAsc() {
        return artistRepository.findAllByOrderBySceneNameAsc()
                .stream()
                .map(artist -> modelMapper.map(artist, ArtistDTO.class))
                .collect(Collectors.toList());
    }

    public List<ArtistDTO> findAllArtistsSortedDesc() {
        return artistRepository.findAllByOrderBySceneNameDesc()
                .stream()
                .map(artist -> modelMapper.map(artist, ArtistDTO.class))
                .collect(Collectors.toList());
    }











}
