package com.barbershop.ru.project.dto;

import com.barbershop.ru.project.models.Client;
import com.barbershop.ru.project.models.Staff;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDTO {

    @NotNull
    private StaffDTO staff;

    @NotNull
    private ClientDTO client;

    @NotNull
    private int serviceId;

    @NotNull
    @FutureOrPresent
    private Date data;
}
