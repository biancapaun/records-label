package com.recordslabel.labelapp.services;

import com.recordslabel.labelapp.dtos.AlbumDTO;

import java.util.List;

public interface AlbumService {

    long findAllAlbums();
    List<AlbumDTO> findAlbumsByArtistId(Long id);
    void createAlbumForArtist(AlbumDTO albumDTO);

}
