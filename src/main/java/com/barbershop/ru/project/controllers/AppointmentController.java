package com.barbershop.ru.project.controllers;


import com.barbershop.ru.project.models.Appointment;
import com.barbershop.ru.project.services.AppointmentService;
import com.barbershop.ru.project.util.AppointmentControllerUtil;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final AppointmentControllerUtil appointmentUtil;

    @Autowired
    public AppointmentController(AppointmentService appointmentService, AppointmentControllerUtil appointmentUtil) {
        this.appointmentService = appointmentService;
        this.appointmentUtil = appointmentUtil;
    }

    @GetMapping("/check")
    @CrossOrigin()
    @Tag(name = "Все записи", description = "Получение полного списка записей, которые есть в бд")
    public List<Appointment> getListAppointments() {
        return appointmentService.findAll();
    }

    @GetMapping("/time/{barbershopId}")
    @CrossOrigin()
    @Tag(name = "Получение свободного времени")
    public List<String> getAvailableTime(@RequestParam(name = "date") String strDate, @PathVariable(name = "barbershopId") int barbershopId) {

        Date date = appointmentUtil.stringToDate(strDate);
        return appointmentService.checkAvailableTime(date, barbershopId);
    }

    @GetMapping("/staff_time/{master_id}")
    @CrossOrigin()
    @Tag(name = "Получение свободного времени для мастера")
    public List<String> getAvailableTimeForMaster(@RequestParam(name = "date") String strDate, @PathVariable(name = "master_id") int masterId) {
        Date date = appointmentUtil.stringToDate(strDate);
        return appointmentService.findAppointmentByStaffId(date, masterId);
    }

    @PostMapping("/add")
    @CrossOrigin()
    @Tag(name = "Добавление записи")
    public void addAppointment(@RequestBody Appointment appointment) {
        appointmentService.save(appointment);
    }
}
