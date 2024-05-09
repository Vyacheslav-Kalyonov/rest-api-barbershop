package com.barbershop.ru.project.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;

@Entity
@Table(name = "Staff")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Staff {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "barbershop_id", referencedColumnName = "id")
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
    private Position position;

    @Column(name = "phone")
    private Long phone;

    @Column(name = "mail")
    private String mail;

    @OneToMany(mappedBy = "staff")
    private List<Appointment> appointments;

    @ManyToMany()
    @JoinTable(name = "master_service",
    joinColumns = @JoinColumn(name = "staff_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "service_id", referencedColumnName = "id"))
    private List<Service> impossibleServices;
}
