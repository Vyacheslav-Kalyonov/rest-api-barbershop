package com.barbershop.ru.project.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Table(name = "Position")
@Getter
@Setter
public class Position {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "position")
    private String position;

    @Column(name = "has_accept_appointments")
    private Boolean hasAcceptAppointments;

    @OneToMany(mappedBy = "position")
    private List<Staff> staffList;

    public Position() {}

    public Position(Long id, String position, Boolean hasAcceptAppointments) {
        this.id = id;
        this.position = position;
        this.hasAcceptAppointments = hasAcceptAppointments;
    }
}
