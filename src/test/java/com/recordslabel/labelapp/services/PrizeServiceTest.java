package com.recordslabel.labelapp.services;

import com.recordslabel.labelapp.dtos.PrizeDTO;
import com.recordslabel.labelapp.entities.Artist;
import com.recordslabel.labelapp.entities.Prize;
import com.recordslabel.labelapp.repositories.ArtistRepository;
import com.recordslabel.labelapp.repositories.PrizeRepository;
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
public class PrizeServiceTest {

    @Mock
    PrizeRepository prizeRepository;

    @Mock
    ArtistRepository artistRepository;

    @Mock
    ModelMapper modelMapper;

    @InjectMocks
    PrizeServiceImpl prizeService;

    @Test
    void testFindPrizes_whenArtistExists_expectPrizesDto(){
        // given
        Long artistId = 1L;
        Artist artist = new Artist();
        artist.setId(artistId);

        Prize prize = new Prize();
        prize.setId(1L);

        artist.setPrizes(List.of(prize));

        PrizeDTO prizeDTO = new PrizeDTO();
        prizeDTO.setId(1L);

        // when
        when(artistRepository.findById(artistId)).thenReturn(Optional.of(artist));
        when(modelMapper.map(prize, PrizeDTO.class)).thenReturn(prizeDTO);

        List<PrizeDTO> result = prizeService.findPrizesById(artistId);

        //then
        assertEquals(1, result.size());

        verify(artistRepository, times(1)).findById(artistId);

    }
}
