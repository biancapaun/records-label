package com.recordslabel.labelapp.services;

import com.recordslabel.labelapp.dtos.AlbumDTO;
import com.recordslabel.labelapp.entities.Album;
import com.recordslabel.labelapp.entities.Artist;
import com.recordslabel.labelapp.entities.Genre;
import com.recordslabel.labelapp.exceptions.ResourceNotFoundException;
import com.recordslabel.labelapp.repositories.AlbumRepository;
import com.recordslabel.labelapp.repositories.ArtistRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService {

    private static final Logger logger =  LoggerFactory.getLogger(ArtistServiceImpl.class);

    private final AlbumRepository albumRepository;
    ArtistRepository artistRepository;
    ModelMapper modelMapper;

    public AlbumServiceImpl(ArtistRepository artistRepository, ModelMapper modelMapper, AlbumRepository albumRepository) {
        this.artistRepository = artistRepository;
        this.modelMapper = modelMapper;
        this.albumRepository = albumRepository;
    }

    @Override
    public long findAllAlbums() {
        return albumRepository.count();
    }

    @Override
    public List<AlbumDTO> findAlbumsByArtistId(Long id) {
        logger.info("Fetching albums for artist with ID: {}", id);

        Artist artist = artistRepository.findByIdWithAlbums(id)
                .orElseThrow(() -> {
                    logger.warn("Artist with id {} not found when fetching albums", id);
                    return new ResourceNotFoundException("Artist with id " + id + " does not exist!");});

        List<AlbumDTO> albums =  artist.getAlbums().stream()
                .map(album -> modelMapper.map(album, AlbumDTO.class))
                .toList();
        logger.debug("Found {} albums for artist ID {}", albums.size(), id);
        return albums;
    }

    @Override
    @Transactional
    public void createAlbumForArtist(AlbumDTO albumDTO) {
        logger.info("Creating album '{}' for artist ID: {}", albumDTO.getTitle(), albumDTO.getArtistId());

        Artist artist = artistRepository.findById(albumDTO.getArtistId())
                .orElseThrow(() -> {
                    logger.warn("Artist with id {} not found when creating album", albumDTO.getArtistId());
                    return new ResourceNotFoundException("Artist with id " + albumDTO.getArtistId() + " does not exist!");
                });


        Album album = modelMapper.map(albumDTO, Album.class);
        Genre genre = modelMapper.map(albumDTO.getGenre(), Genre.class);
        album.setGenre(genre);
        album.setArtist(artist);
        albumRepository.save(album);

        logger.debug("Album '{}' saved successfully for artist ID: {}", album.getTitle(), albumDTO.getArtistId());
    }

}
