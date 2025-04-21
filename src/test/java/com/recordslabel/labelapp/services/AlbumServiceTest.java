package com.recordslabel.labelapp.services;

import com.recordslabel.labelapp.dtos.AlbumDTO;
import com.recordslabel.labelapp.dtos.GenreDTO;
import com.recordslabel.labelapp.entities.Album;
import com.recordslabel.labelapp.entities.Artist;
import com.recordslabel.labelapp.entities.Genre;
import com.recordslabel.labelapp.repositories.AlbumRepository;
import com.recordslabel.labelapp.repositories.ArtistRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AlbumServiceTest {

    @Mock
    AlbumRepository albumRepository;

    @Mock
    ArtistRepository artistRepository;

    @Mock
    ModelMapper modelMapper;

    @InjectMocks
    AlbumServiceImpl albumService;


    @Test
    void testFindAlbums_whenArtistExists_expectAlbumsDto(){
        // given
        Long artistId = 1L;
        Artist artist = new Artist();
        artist.setId(artistId);

        Album album = new Album();
        album.setId(1L);
        album.setTitle("test");
        artist.setAlbums(List.of(album));

        AlbumDTO albumDTO = new AlbumDTO();
        albumDTO.setId(1L);
        albumDTO.setTitle("test");

        // when
        when(artistRepository.findByIdWithAlbums(artistId)).thenReturn(Optional.of(artist));
        when(modelMapper.map(album, AlbumDTO.class)).thenReturn(albumDTO);

        List<AlbumDTO> result = albumService.findAlbumsByArtistId(artistId);

        //then
        assertEquals(1, result.size());
        assertEquals("test", result.get(0).getTitle());

        verify(artistRepository, times(1)).findByIdWithAlbums(artistId);

    }

    @Test
    void testCreateAlbums_whenArtistExists_shouldMapAndSaveEntity(){
        //given
        Genre genre = new Genre();
        genre.setId(111L);
        genre.setGenreName("pop");

        GenreDTO genreDTO = new GenreDTO();
        genreDTO.setGenreName("pop");


        Long id = 1L;
        Album album = new Album();
        album.setId(id);
        album.setTitle("test");
        album.setGenre(genre);


        AlbumDTO albumDTO = new AlbumDTO();
        albumDTO.setId(id);
        albumDTO.setTitle("test");
        albumDTO.setArtistId(11L);
        albumDTO.setGenre(genreDTO);

        Artist artist = new Artist();

        // when
        when(artistRepository.findById(albumDTO.getArtistId())).thenReturn(Optional.of(artist));
        when(modelMapper.map(albumDTO, Album.class)).thenReturn(album);
        when(modelMapper.map(albumDTO.getGenre(), Genre.class)).thenReturn(genre);

        albumService.createAlbumForArtist(albumDTO);

        //then
        assertEquals(artist, album.getArtist());
        assertEquals(genre, album.getGenre());

        verify(albumRepository).save(album);
        verify(artistRepository, times(1)).findById(albumDTO.getArtistId());

    }





}
