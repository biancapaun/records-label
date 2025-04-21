package com.recordslabel.labelapp.controllers;

import com.recordslabel.labelapp.dtos.*;
import com.recordslabel.labelapp.services.ProducerServiceImpl;
import com.recordslabel.labelapp.services.ProductionServiceImpl;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/producer")
public class ProducerController {

    ProducerServiceImpl producerService;
    ProductionServiceImpl productionService;

    public ProducerController(ProducerServiceImpl producerService, ProductionServiceImpl productionService) {
        this.producerService = producerService;
        this.productionService = productionService;
    }


    @GetMapping("")
    public String producerList(Model model){
        List<ProducerDTO> producers = producerService.findAllProducers();
        model.addAttribute("producers", producers);
        return "producer/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        ProducerDTO producer = producerService.findProducerById(id);
        model.addAttribute("producer",producer);
        return "producer/form";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("producer", new ProducerDTO());
        return "producer/form";
    }

    @PostMapping("/create")
    public String createProducer(@Valid @ModelAttribute("producer") ProducerDTO producerDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "producer/form";
        }
        producerService.createProducer(producerDTO);
        return "redirect:/producer";
    }

    @PostMapping("/edit/{id}")
    public String updateProducer(@PathVariable Long id, @ModelAttribute("producer") ProducerDTO producerDTO) {
        producerService.updateProducer(id, producerDTO);
        return "redirect:/producer";
    }

    @GetMapping("/delete/{id}")
    public String deleteProducer(@PathVariable Long id) {
        producerService.deleteProducerById(id);
        return "redirect:/producer";
    }

    @GetMapping("/details/{id}")
    public String showProducerDetails(@PathVariable Long id, Model model) {
        ProducerDTO producer = producerService.findProducerById(id);
        model.addAttribute("producer", producer);

        List<ProductionDTO> productions = productionService.findProductionsByProducerId(id);
        model.addAttribute("productions", productions);
        return "producer/details";
    }




}
