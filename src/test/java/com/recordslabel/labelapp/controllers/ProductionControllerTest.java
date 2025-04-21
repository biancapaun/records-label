package com.recordslabel.labelapp.controllers;


import com.recordslabel.labelapp.dtos.ProductionDTO;
import com.recordslabel.labelapp.services.ProductionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductionController.class)
@AutoConfigureMockMvc
@Profile("dev")
public class ProductionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductionService productionService;

    @Test
    @WithMockUser(username = "admin", roles = "ADMIN")
    void testShowCreateForm_shouldReturnFormView() throws Exception {
        Long producerId = 1L;

        mockMvc.perform(get("/production/create")
                        .param("producerId", producerId.toString()))
                .andExpect(status().isOk())
                .andExpect(view().name("production/form"))
                .andExpect(model().attributeExists("production"));
    }

    @Test
    @WithMockUser(username = "admin", roles = "ADMIN")
    void testCreateProduction_shouldRedirect() throws Exception {
        mockMvc.perform(post("/production/create")
                        .param("producerId", "1")
                        .param("productionType", "Master")
                        .param("budget", "50000")
                        .with(csrf()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/producer/details/1"));

        verify(productionService).createProductionForProducer(any(ProductionDTO.class));
    }


}
