package com.barbershop.ru.project.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Client")
@Getter
@Setter
public class Client {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "phone")
    private Long phone;

    @Column(name = "mail")
    private String mail;

    @OneToMany(mappedBy = "client")
    private List<Appointment> appointments;

    public Client() {

    }

    public Client(String name, String surname, Long phone, String mail) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.mail = mail;
    }
}
