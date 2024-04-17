package com.barbershop.ru.project.controllers;

import com.barbershop.ru.project.models.Service;
import com.barbershop.ru.project.models.Staff;
import com.barbershop.ru.project.services.ServiceService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointment")
public class ServiceController {

    private final ServiceService serviceService;

    @Autowired
    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @GetMapping("/services")
    @CrossOrigin()
    @Tag(name = "Получение всех услуг")
    public List<Service> getServices() {
        return serviceService.findAll();
    }

    @GetMapping("/service/master/{id}")
    @CrossOrigin()
    @Tag(name = "Получение мастера", description = "Получение списка мастеров, которые могут выполнить услугу")
    public List<Staff> getMasterByService(@PathVariable(name="id") int id) {
        Service service = serviceService.findOne(id);
        return service.getMasterCapablePerformingService();
    }
}
