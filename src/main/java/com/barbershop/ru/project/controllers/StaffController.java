package com.barbershop.ru.project.controllers;


import com.barbershop.ru.project.models.Service;
import com.barbershop.ru.project.models.Staff;
import com.barbershop.ru.project.services.StaffService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/appointment")
public class StaffController {

    private final StaffService staffService;

    @Autowired
    public StaffController(StaffService staffService) {
        this.staffService = staffService;
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
    public Staff getMaster(@PathVariable(name = "id") int id) {
        return staffService.findOne(id);
    }

    @GetMapping("/master/service/{id}")
    @CrossOrigin()
    @Tag(name = "Получение услуг у мастера", description = "Получение списка возможных услуг у мастера")
    public List<Service> getServicesByMaster(@PathVariable(name = "id") int id) {
        Staff master = staffService.findOne(id);
        return master.getImpossibleServices();
    }
}
