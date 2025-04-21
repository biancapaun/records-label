package com.recordslabel.labelapp.controllers;

import com.recordslabel.labelapp.dtos.ProductionDTO;
import com.recordslabel.labelapp.entities.ProductionId;
import com.recordslabel.labelapp.services.ProductionService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/production")
public class ProductionController {

    ProductionService productionService;

    ProductionController(ProductionService productionService) {
        this.productionService = productionService;
    }

    @GetMapping("/create")
    public String showCreateForm(@RequestParam("producerId") Long producerId, Model model) {
        ProductionDTO productionDTO = new ProductionDTO();
        ProductionId id = new ProductionId();
        productionDTO.setProducerId(producerId);
        model.addAttribute("production", productionDTO);
        return "production/form";
    }

    @PostMapping("/create")
    public String createProduction(@Valid @ModelAttribute("production") ProductionDTO productionDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "production/form";
        }
        productionService.createProductionForProducer(productionDTO);
        return "redirect:/producer/details/" + productionDTO.getProducerId();
    }
}
