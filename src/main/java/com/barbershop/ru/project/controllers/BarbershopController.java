package com.barbershop.ru.project.controllers;

import com.barbershop.ru.project.dto.BarbershopDTO;
import com.barbershop.ru.project.models.Barbershop;
import com.barbershop.ru.project.services.BarbershopService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class BarbershopController {

    private final BarbershopService barbershopService;
    private final ModelMapper modelMapper;

    @Autowired
    public BarbershopController(BarbershopService barbershopService, ModelMapper modelMapper) {
        this.barbershopService = barbershopService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/barbershop")
    @CrossOrigin()
    @Tag(name = "Получение полного списка барбершопов")
    public List<BarbershopDTO> getBarbershops() {
        return barbershopService.findAll().stream().map(this::convertToBarbershopDTO).toList();
    }

    private BarbershopDTO convertToBarbershopDTO(Barbershop barbershop) {
        return modelMapper.map(barbershop, BarbershopDTO.class);
    }
}
