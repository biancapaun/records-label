package com.recordslabel.labelapp.services;

import com.recordslabel.labelapp.dtos.ArtistDTO;
import com.recordslabel.labelapp.entities.Artist;
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
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ArtistServiceTest {

    @Mock
    ArtistRepository artistRepository;

    @Mock
    ModelMapper modelMapper;

    @InjectMocks
    ArtistServiceImpl artistService;

    @Test
    void testFindAllArtists(){
        // given
        Artist artist = new Artist();
        List<Artist> artists = List.of(artist);

        when(artistRepository.findAllByOrderByIdAsc()).thenReturn(artists);
        when(modelMapper.map(any(Artist.class), eq(ArtistDTO.class))).thenReturn(new ArtistDTO());

        // when
        List<ArtistDTO> result = artistService.findAllArtists();

        // then
        assertEquals(1, result.size());
        verify(artistRepository, times(1)).findAllByOrderByIdAsc();

    }

    @Test
    void testFindArtistById_whenArtistExists_expectArtistDto() {
        // given
        Long id = 1L;
        Artist artist = new Artist();
        artist.setId(id);
        artist.setSceneName("Taylor Swift");

        ArtistDTO dto = new ArtistDTO();
        dto.setId(id);
        dto.setSceneName("Taylor Swift");

        when(artistRepository.findById(id)).thenReturn(Optional.of(artist));
        when(modelMapper.map(artist, ArtistDTO.class)).thenReturn(dto);

        // when
        ArtistDTO result = artistService.findArtistById(id);

        // then
        assertNotNull(result);
        assertEquals("Taylor Swift", result.getSceneName());
        verify(artistRepository, times(1)).findById(id);
    }

    @Test
    void testCreateArtist_shouldMapAndSaveEntity() {
        // given
        ArtistDTO dto = new ArtistDTO();
        dto.setSceneName("Ed Sheeran");

        Artist artist = new Artist();
        artist.setSceneName("Ed Sheeran");

        when(modelMapper.map(dto, Artist.class)).thenReturn(artist);

        // when
        artistService.createArtist(dto);

        // then
        verify(modelMapper).map(dto, Artist.class);
        verify(artistRepository).save(artist);
    }

    @Test
    void testUpdateArtist_whenArtistExists_shouldMapAndSave() {
        // given
        Long id = 1L;
        ArtistDTO dto = new ArtistDTO();
        dto.setSceneName("New name");

        Artist existingArtist = new Artist();
        existingArtist.setId(id);
        existingArtist.setSceneName("Old name");

        when(artistRepository.findById(id)).thenReturn(Optional.of(existingArtist));

        // when
        artistService.updateArtist(id, dto);

        // then
        verify(modelMapper).map(dto, existingArtist);
        verify(artistRepository).save(existingArtist);
    }


    @Test
    void testDeleteArtistById_whenArtistExists_shouldCallRepositoryDelete() {
        // given
        Long id = 1L;

        // when
        artistService.deleteArtistById(id);

        // then
        verify(artistRepository).deleteById(id);
    }







}
