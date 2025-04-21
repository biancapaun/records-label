package com.recordslabel.labelapp.controllers;

import com.recordslabel.labelapp.dtos.*;
import com.recordslabel.labelapp.services.*;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ArtistController.class)
@AutoConfigureMockMvc
@Profile("dev")
public class ArtistControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ArtistServiceImpl artistService;

    @MockBean
    private AlbumServiceImpl albumService;

    @MockBean
    private SongServiceImpl songService;

    @MockBean
    private PrizeServiceImpl prizeService;

    @MockBean
    private ContractServiceImpl contractService;

    @Test
    @WithMockUser(username = "admin", password = "12345", roles = "ADMIN")
    void testArtistList_returnsListViewWithArtistsSortedAsc() throws Exception {
        List<ArtistDTO> mockArtists = List.of(new ArtistDTO());
        when(artistService.findAllArtistsSortedAsc()).thenReturn(mockArtists);

        mockMvc.perform(get("/artist")
                        .param("sortDir", "asc"))
                .andExpect(status().isOk())
                .andExpect(view().name("artist/list"))
                .andExpect(model().attribute("artists", mockArtists))
                .andExpect(model().attribute("sortDir", "asc"));

        verify(artistService, times(1)).findAllArtistsSortedAsc();
    }


    @Test
    @WithMockUser(username = "admin", password = "12345", roles = "ADMIN")
    void testShowEditForm_shouldReturnFormWithArtist() throws Exception {
        Long id = 1L;
        ArtistDTO artist = new ArtistDTO();
        artist.setId(id);

        when(artistService.findArtistById(id)).thenReturn(artist);

        mockMvc.perform(get("/artist/edit/{id}", id))
                .andExpect(status().isOk())
                .andExpect(view().name("artist/form"))
                .andExpect(model().attribute("artist", artist));

        verify(artistService).findArtistById(id);
    }

    @Test
    @WithMockUser(username = "admin", password = "12345", roles = "ADMIN")
    void testUpdateArtist_shouldRedirect() throws Exception {
        Long id = 1L;

        mockMvc.perform(post("/artist/edit/{id}", id)
                .param("sceneName", "Updated artist")
                .param("realName", "Updated real name")
                .param("originCountry", "Spain")
                .with(csrf()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/artist"));
        ArgumentCaptor<ArtistDTO> captor = ArgumentCaptor.forClass(ArtistDTO.class);
        verify(artistService).updateArtist(eq(id), captor.capture());

        ArtistDTO artist = captor.getValue();
        assertEquals("Updated artist", artist.getSceneName());
        assertEquals("Updated real name", artist.getRealName());
    }

    @Test
    @WithMockUser(username = "admin", password = "12345", roles = "ADMIN")
    void testDeleteArtist_shouldRedirect() throws Exception {
        Long id = 1L;

        mockMvc.perform(get("/artist/delete/{id}", id))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/artist"));

        verify(artistService).deleteArtistById(id);
    }

    @Test
    @WithMockUser(username = "admin", password = "12345", roles = "ADMIN")
    void testCreateArtist_shouldRedirectWhenValid() throws Exception {
        mockMvc.perform(post("/artist/create")
                        .param("sceneName", "Test Artist")
                        .param("realName", "Real Name")
                        .param("dateOfBirth", "2002-09-19")
                        .param("originCountry", "Mark Town")
                        .with(csrf()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/artist"));

        verify(artistService).createArtist(any(ArtistDTO.class));
    }

    @Test
    @WithMockUser(username = "admin", password = "12345", roles = "ADMIN")
    void testShowArtistDetails_shouldReturnDetailsView() throws Exception {
        Long id = 1L;

        GenreDTO genreDTO = new GenreDTO();
        genreDTO.setGenreName("Pop");

        ArtistDTO artistDTO = new ArtistDTO();
        AlbumDTO album = new AlbumDTO();
        album.setId(2L);
        album.setGenre(genreDTO);

        LabelDTO labelDTO = new LabelDTO();
        labelDTO.setId(5L);
        labelDTO.setLabelName("Global Music");

        ContractDTO contractDTO = new ContractDTO();
        contractDTO.setId(100L);
        contractDTO.setLabel(labelDTO);

        when(artistService.findArtistById(id)).thenReturn(artistDTO);
        when(albumService.findAlbumsByArtistId(id)).thenReturn(List.of(album));
        when(songService.findSongByAlbumId(album.getId())).thenReturn(List.of(new SongDTO()));
        when(prizeService.findPrizesById(id)).thenReturn(List.of(new PrizeDTO()));
        when(contractService.findContractsById(id)).thenReturn(List.of(contractDTO));

        mockMvc.perform(get("/artist/details/{id}", id))
                .andExpect(status().isOk())
                .andExpect(view().name("artist/details"))
                .andExpect(model().attributeExists("artist", "albums", "prizes", "contracts", "newSong"));

        verify(artistService).findArtistById(id);
    }









}
