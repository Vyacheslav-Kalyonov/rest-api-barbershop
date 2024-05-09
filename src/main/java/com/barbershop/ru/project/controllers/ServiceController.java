package com.barbershop.ru.project.controllers;

import com.barbershop.ru.project.dto.ServiceDTO;
import com.barbershop.ru.project.dto.StaffDTO;
import com.barbershop.ru.project.models.Service;
import com.barbershop.ru.project.models.Staff;
import com.barbershop.ru.project.services.ServiceService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointment")
public class ServiceController {

    private final ServiceService serviceService;
    private final ModelMapper modelMapper;

    @Autowired
    public ServiceController(ServiceService serviceService, ModelMapper modelMapper) {
        this.serviceService = serviceService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/services")
    @CrossOrigin()
    @Tag(name = "Получение всех услуг")
    public List<ServiceDTO> getServices() {
        return serviceService.findAll().stream().map(this::convertToServiceDTO).toList();
    }

    @GetMapping("/service/master/{id}")
    @CrossOrigin()
    @Tag(name = "Получение мастера", description = "Получение списка мастеров, которые могут выполнить услугу")
    public List<StaffDTO> getMasterByService(@PathVariable(name="id") int id) {
        Service service = serviceService.findOne(id);
        return service.getMasterCapablePerformingService().stream().map(this::convertToStaffDTO).toList();
    }

    private ServiceDTO convertToServiceDTO(Service service) {
        return modelMapper.map(service, ServiceDTO.class);
    }

    private StaffDTO convertToStaffDTO(Staff staff) {
        return modelMapper.map(staff, StaffDTO.class);
    }
}
