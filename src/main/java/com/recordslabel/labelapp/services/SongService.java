package com.recordslabel.labelapp.services;

import com.recordslabel.labelapp.dtos.SongDTO;

import java.util.List;

public interface SongService {

    List<SongDTO> findAllSongs();
    List<SongDTO> findSongByAlbumId(Long id);
    void createSongForAlbum(SongDTO songDTO);

}
