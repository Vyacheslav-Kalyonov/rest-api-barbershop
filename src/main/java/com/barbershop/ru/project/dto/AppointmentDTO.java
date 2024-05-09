package com.barbershop.ru.project.dto;

import com.barbershop.ru.project.models.Client;
import com.barbershop.ru.project.models.Staff;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDTO {

    private StaffDTO staff;
    private ClientDTO client;
    private int serviceId;
    private Date data;
}
