package com.recordslabel.labelapp.controllers;

import com.recordslabel.labelapp.dtos.*;
import com.recordslabel.labelapp.services.ProducerServiceImpl;
import com.recordslabel.labelapp.services.ProductionServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProducerController.class)
@AutoConfigureMockMvc
@Profile("dev")
public class ProducerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ProducerServiceImpl producerService;

    @MockBean
    ProductionServiceImpl productionService;

    @Test
    @WithMockUser(username = "admin", password = "12345", roles = "ADMIN")
    void testProducerList_returnsListViewWithProducers() throws Exception {
        List<ProducerDTO> mockProducers = List.of(new ProducerDTO());
        when(producerService.findAllProducers()).thenReturn(mockProducers);

        mockMvc.perform(get("/producer"))
                .andExpect(status().isOk())
                .andExpect(view().name("producer/list"))
                .andExpect(model().attribute("producers", mockProducers));

        verify(producerService, times(1)).findAllProducers();
    }

    @Test
    @WithMockUser(username = "admin", password = "12345", roles = "ADMIN")
    void testShowEditForm_shouldReturnFormWithProducer() throws Exception {
        Long id = 1L;
        ProducerDTO producer = new ProducerDTO();
        producer.setId(id);

        when(producerService.findProducerById(id)).thenReturn(producer);

        mockMvc.perform(get("/producer/edit/{id}", id))
                .andExpect(status().isOk())
                .andExpect(view().name("producer/form"))
                .andExpect(model().attribute("producer", producer));

        verify(producerService).findProducerById(id);
    }

    @Test
    @WithMockUser(username = "admin", password = "12345", roles = "ADMIN")
    void testUpdateProducer_shouldRedirect() throws Exception {
        Long id = 1L;

        mockMvc.perform(post("/producer/edit/{id}", id)
                        .param("name", "Updated producer name")
                        .param("specialization", "Updated specialization")
                        .param("originCountry", "Spain")
                        .with(csrf()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/producer"));
        ArgumentCaptor<ProducerDTO> captor = ArgumentCaptor.forClass(ProducerDTO.class);
        verify(producerService).updateProducer(eq(id), captor.capture());

        ProducerDTO producerDTO = captor.getValue();
        assertEquals("Updated producer name", producerDTO.getName());
        assertEquals("Updated specialization", producerDTO.getSpecialization());
    }

    @Test
    @WithMockUser(username = "admin", password = "12345", roles = "ADMIN")
    void testDeleteProducer_shouldRedirect() throws Exception {
        Long id = 1L;

        mockMvc.perform(get("/producer/delete/{id}", id))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/producer"));

        verify(producerService).deleteProducerById(id);
    }

    @Test
    @WithMockUser(username = "admin", password = "12345", roles = "ADMIN")
    void testCreateProducer_shouldRedirectWhenValid() throws Exception {
        mockMvc.perform(post("/producer/create")
                        .param("name", "producer name")
                        .param("specialization", "specialization")
                        .param("originCountry", "Spain")
                        .with(csrf()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/producer"));

        verify(producerService).createProducer(any(ProducerDTO.class));
    }

    @Test
    @WithMockUser(username = "admin", password = "12345", roles = "ADMIN")
    void testShowProducerDetails_shouldReturnDetailsView() throws Exception {
        Long id = 1L;

        ProducerDTO producer = new ProducerDTO();
        producer.setId(1L);
        producer.setName("producer name");
        producer.setSpecialization("mix");
        producer.setOriginCountry("Spain");

        ProductionDTO productionDTO = new ProductionDTO();
        productionDTO.setProducerId(producer.getId());
        productionDTO.setProductionType("master");
        productionDTO.setBudget(new BigDecimal(1111));

        when(producerService.findProducerById(id)).thenReturn(producer);
        when(productionService.findProductionsByProducerId(id)).thenReturn(List.of(productionDTO));

        mockMvc.perform(get("/producer/details/{id}", id))
                .andExpect(status().isOk())
                .andExpect(view().name("producer/details"))
                .andExpect(model().attributeExists("producer", "productions"));

        verify(producerService).findProducerById(id);
    }


}
