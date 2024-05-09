package com.barbershop.ru.project.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Entity
@Table(name = "Staff")
@Getter
@Setter
public class Staff {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "barbershop_id", referencedColumnName = "id")
    @JsonIgnore
    private Barbershop barbershop;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "patronymic")
    @JsonIgnore
    private String patronymic;

    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    @JsonIgnore
    private Position position;

    @Column(name = "phone")
    private Long phone;

    @Column(name = "mail")
    @JsonIgnore
    private String mail;

    @OneToMany(mappedBy = "staff")
    @JsonIgnore
    private List<Appointment> appointments;

    @ManyToMany()
    @JoinTable(name = "master_service",
    joinColumns = @JoinColumn(name = "staff_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "service_id", referencedColumnName = "id"))
    @JsonIgnore
    private List<Service> impossibleServices;

    public Staff() {
    }

    public Staff(Barbershop barbershop, String name, String surname, String patronymic, Position position, Long phone, String mail) {
        this.barbershop = barbershop;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.position = position;
        this.phone = phone;
        this.mail = mail;
    }
}
