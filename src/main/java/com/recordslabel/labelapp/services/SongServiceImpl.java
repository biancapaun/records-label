package com.recordslabel.labelapp.services;

import com.recordslabel.labelapp.dtos.SongDTO;
import com.recordslabel.labelapp.entities.Album;
import com.recordslabel.labelapp.entities.Song;
import com.recordslabel.labelapp.exceptions.ResourceNotFoundException;
import com.recordslabel.labelapp.repositories.AlbumRepository;
import com.recordslabel.labelapp.repositories.SongRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SongServiceImpl implements SongService {

    private static final Logger logger =  LoggerFactory.getLogger(ArtistServiceImpl.class);


    AlbumRepository albumRepository;
    SongRepository songRepository;

    ModelMapper modelMapper;

    public SongServiceImpl(SongRepository songRepository, AlbumRepository albumRepository, ModelMapper modelMapper){
        this.songRepository = songRepository;
        this.albumRepository = albumRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public List<SongDTO> findAllSongs() {
        logger.info("Fetching all songs");
        List<Song> songs = new LinkedList<>();
        songRepository.findAll()
                .iterator().forEachRemaining(songs :: add);

        List<SongDTO> songList =  songs.stream().map(song -> modelMapper.map(song, SongDTO.class))
                .collect(Collectors.toList());
        logger.debug("Found {} artists", songList.size());
        return songList;
    }

    @Override
    public List<SongDTO> findSongByAlbumId(Long id) {
        logger.info("Fetching songs for albums with ID: {}", id);

        Optional<Album> album = albumRepository.findById(id);
        if (!album.isPresent()) {
            logger.warn("Album with id {} not found when fetching songs", id);
            throw new ResourceNotFoundException("Album with id " + id + " not found");
        }
        List<SongDTO> songs =  album.get().getSongs().stream()
                .map(song -> modelMapper.map(song, SongDTO.class))
                .collect(Collectors.toList());
        logger.debug("Found {} songs for album ID {}", songs.size(), id);
        return songs;
    }

    @Override
    @Transactional
    public void createSongForAlbum(SongDTO songDTO) {
        logger.info("Creating song '{}' for album ID: {}", songDTO.getTitle(), songDTO.getAlbumId());

        Album album = albumRepository.findById(songDTO.getAlbumId())
                .orElseThrow(() -> {
                    logger.warn("Album with id {} not found when creating song", songDTO.getAlbumId());
                    return new ResourceNotFoundException("Album with id " + songDTO.getAlbumId() + " does not exist!");});

        Song song = new Song();
        song.setTitle(songDTO.getTitle());
        song.setAlbum(album);
        songRepository.save(song);

        logger.debug("Song '{}' saved successfully for album ID: {}", song.getTitle(), songDTO.getAlbumId());

    }
}
