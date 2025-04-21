package com.recordslabel.labelapp.services;

import com.recordslabel.labelapp.dtos.SongDTO;
import com.recordslabel.labelapp.entities.Album;
import com.recordslabel.labelapp.entities.Song;
import com.recordslabel.labelapp.repositories.AlbumRepository;
import com.recordslabel.labelapp.repositories.SongRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SongServiceTest {

    @Mock
    AlbumRepository albumRepository;

    @Mock
    SongRepository songRepository;

    @Mock
    ModelMapper modelMapper;

    @InjectMocks
    SongServiceImpl songService;

    @Test
    void testFindAllSongs(){
        // given
        Song song = new Song();
        List<Song> songs = List.of(song);

        when(songRepository.findAll()).thenReturn(songs);
        when(modelMapper.map(any(Song.class), eq(SongDTO.class))).thenReturn(new SongDTO());

        // when
        List<SongDTO> result = songService.findAllSongs();

        // then
        assertEquals(1, result.size());
        verify(songRepository, times(1)).findAll();

    }

    @Test
    void testFindSongsByAlbumId_whenAlbumExists_expectSongsDto() {
        // given
        Long albumId = 1L;

        Song song = new Song();
        song.setId(100L);
        song.setTitle("Test song");

        SongDTO songDTO = new SongDTO();
        songDTO.setId(100L);
        songDTO.setTitle("Test song");

        Album album = new Album();
        album.setId(albumId);
        album.setSongs(List.of(song));

        when(albumRepository.findById(albumId)).thenReturn(Optional.of(album));
        when(modelMapper.map(song, SongDTO.class)).thenReturn(songDTO);

        // when
        List<SongDTO> result = songService.findSongByAlbumId(albumId);

        // then
        assertEquals(1, result.size());
        assertEquals("Test song", result.get(0).getTitle());
        verify(albumRepository).findById(albumId);
    }



    @Test
    void testCreateSong_whenAlbumExists_shouldMapAndSaveEntity(){
        //given
        Long id = 1L;
        Song song = new Song();
        song.setId(id);
        song.setTitle("test");

        SongDTO songDTO = new SongDTO();
        songDTO.setId(id);
        songDTO.setTitle("test");
        songDTO.setAlbumId(11L);

        Album album = new Album();
        album.setId(id);

        // when
        when(albumRepository.findById(songDTO.getAlbumId())).thenReturn(Optional.of(album));

        songService.createSongForAlbum(songDTO);

        //then
        assertEquals("test", song.getTitle());

        verify(songRepository).save(song);
        verify(albumRepository, times(1)).findById(songDTO.getAlbumId());

    }


}
