package com.barbershop.ru.project.models.staff;

import com.barbershop.ru.project.models.Appointment;
import com.barbershop.ru.project.models.Barbershop;
import com.barbershop.ru.project.models.Service;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


import java.util.List;

@Entity
@Table(name = "Staff")
public class Staff {

    @Id
    @Column(name = "id")
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

    @Column(name = "position_id")
    @Enumerated(EnumType.ORDINAL)
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Barbershop getBarbershop() {
        return barbershop;
    }

    public void setBarbershop(Barbershop barbershop) {
        this.barbershop = barbershop;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public List<Service> getImpossibleServices() {
        return impossibleServices;
    }

    public void setImpossibleServices(List<Service> impossibleServices) {
        this.impossibleServices = impossibleServices;
    }
}
