package com.recordslabel.labelapp.services;

import com.recordslabel.labelapp.dtos.ArtistDTO;
import com.recordslabel.labelapp.entities.Artist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ArtistService {

    List<ArtistDTO> findAllArtists();
    ArtistDTO findArtistById(Long id);
    void createArtist(ArtistDTO artistDTO);
    void updateArtist(Long id, ArtistDTO artistDTO);
    void deleteArtistById(Long id);




}
