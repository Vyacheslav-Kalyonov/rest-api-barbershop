package com.barbershop.ru.project.exception.appointment;

public class AppointmentNotAddException extends RuntimeException {
    private String msg;

    public AppointmentNotAddException(String msg) {
        super(msg);
    }
}
