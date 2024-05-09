package com.barbershop.ru.project.controllers;


import com.barbershop.ru.project.dto.ServiceDTO;
import com.barbershop.ru.project.dto.StaffDTO;
import com.barbershop.ru.project.models.Service;
import com.barbershop.ru.project.models.Staff;
import com.barbershop.ru.project.services.StaffService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/appointment")
public class StaffController {

    private final StaffService staffService;
    private final ModelMapper modelMapper;

    @Autowired
    public StaffController(StaffService staffService, ModelMapper modelMapper) {
        this.staffService = staffService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/masters/{barbershop_id}")
    @CrossOrigin()
    @Tag(name = "Получение мастеров", description = "Получение всех мастеров по id барбершопа")
    public List<Staff> getMasters(@PathVariable(name = "barbershop_id") int id) {
        return staffService.findAllMastersByBarbershopId(id);
    }

    @GetMapping("/master/{id}")
    @CrossOrigin()
    @Tag(name = "Получение мастера по id")
    public StaffDTO getMaster(@PathVariable(name = "id") int id) {
        return convertToStaffDTO(staffService.findOne(id));
    }

    @GetMapping("/master/service/{id}")
    @CrossOrigin()
    @Tag(name = "Получение услуг у мастера", description = "Получение списка возможных услуг у мастера")
    public List<ServiceDTO> getServicesByMaster(@PathVariable(name = "id") int id) {
        Staff master = staffService.findOne(id);
        return master.getImpossibleServices().stream().map(this::convertToServiceDTO).toList();
    }

    private ServiceDTO convertToServiceDTO(Service service) {
        return modelMapper.map(service, ServiceDTO.class);
    }

    private StaffDTO convertToStaffDTO(Staff staff) {
        return modelMapper.map(staff, StaffDTO.class);
    }
}
