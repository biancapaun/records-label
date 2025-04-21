package com.recordslabel.labelapp.services;

import com.recordslabel.labelapp.dtos.ContractDTO;
import com.recordslabel.labelapp.entities.Artist;
import com.recordslabel.labelapp.entities.Contract;
import com.recordslabel.labelapp.repositories.ArtistRepository;
import com.recordslabel.labelapp.repositories.ContractRepository;
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
public class ContractServiceTest {

    @Mock
    ContractRepository contractRepository;

    @Mock
    ArtistRepository artistRepository;

    @Mock
    ModelMapper modelMapper;

    @InjectMocks
    ContractServiceImpl contractService;

    @Test
    void testFindContracts_whenArtistExists_expectContractsDto(){
        // given
        Long artistId = 1L;
        Artist artist = new Artist();
        artist.setId(artistId);

        Contract contract = new Contract();
        contract.setId(1L);

        artist.setContracts(List.of(contract));

        ContractDTO contractDTO = new ContractDTO();
        contractDTO.setId(1L);

        // when
        when(artistRepository.findById(artistId)).thenReturn(Optional.of(artist));
        when(modelMapper.map(contract, ContractDTO.class)).thenReturn(contractDTO);

        List<ContractDTO> result = contractService.findContractsById(artistId);

        //then
        assertEquals(1, result.size());

        verify(artistRepository, times(1)).findById(artistId);

    }
}
