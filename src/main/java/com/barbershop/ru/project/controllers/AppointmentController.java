package com.barbershop.ru.project.controllers;


import com.barbershop.ru.project.dto.AppointmentDTO;
import com.barbershop.ru.project.models.Appointment;
import com.barbershop.ru.project.models.Client;
import com.barbershop.ru.project.services.AppointmentService;
import com.barbershop.ru.project.services.ClientService;
import com.barbershop.ru.project.util.AppointmentControllerUtil;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final AppointmentControllerUtil appointmentUtil;
    private final ClientService clientService;
    private final ModelMapper modelMapper;

    @Autowired
    public AppointmentController(AppointmentService appointmentService, AppointmentControllerUtil appointmentUtil, ClientService clientService, ModelMapper modelMapper) {
        this.appointmentService = appointmentService;
        this.appointmentUtil = appointmentUtil;
        this.clientService = clientService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/check")
    @CrossOrigin()
    @Tag(name = "Все записи", description = "Получение полного списка записей, которые есть в бд")
    public List<AppointmentDTO> getListAppointments() {
        return appointmentService.findAll().stream().map(this::convertToAppointmentDTO).toList();
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
    public ResponseEntity<HttpStatus> addAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        Appointment appointment = convertToAppointment(appointmentDTO);

        Client client = appointment.getClient();
        Client checkClient = clientService.findByPhoneOrMail(client.getPhone(), client.getMail());

        if (checkClient != null) {
            appointment.setClient(checkClient);
        } else {
            clientService.save(client);
        }

        appointmentService.save(appointment);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private AppointmentDTO convertToAppointmentDTO(Appointment appointment) {
        return modelMapper.map(appointment, AppointmentDTO.class);
    }

    private Appointment convertToAppointment(AppointmentDTO appointmentDTO) {
        return modelMapper.map(appointmentDTO, Appointment.class);
    }
}
