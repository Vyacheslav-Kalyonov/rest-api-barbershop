package com.barbershop.ru.project.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "Appointment")
@Getter
@Setter
public class Appointment {

    @Id
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "staff_id", referencedColumnName = "id")
    private Staff staff;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

    @Column(name = "service_id")
    private int serviceId;

    @Column(name = "data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;

    @Column(name = "status_code")
    @Schema(hidden = true)
    private Integer statusCode;

    public Appointment() {

    }

    public Appointment(Staff staff, Client client, int serviceId, Date data, Integer statusCode) {
        this.staff = staff;
        this.client = client;
        this.serviceId = serviceId;
        this.data = data;
        this.statusCode = statusCode;
    }
}
