package com.barbershop.ru.project.exception.appointment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentErrorResponse {
    private String msg;
    private long timestamp;
}
