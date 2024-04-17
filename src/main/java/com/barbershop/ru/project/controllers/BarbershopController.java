package com.barbershop.ru.project.controllers;

import com.barbershop.ru.project.models.Barbershop;
import com.barbershop.ru.project.services.BarbershopService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class BarbershopController {

    private final BarbershopService barbershopService;

    @Autowired
    public BarbershopController(BarbershopService barbershopService) {
        this.barbershopService = barbershopService;
    }

    @GetMapping("/barbershop")
    @CrossOrigin()
    @Tag(name = "Получение полного списка барбершопов")
    public List<Barbershop> getBarbershops() {
        return barbershopService.findAll();
    }
}
