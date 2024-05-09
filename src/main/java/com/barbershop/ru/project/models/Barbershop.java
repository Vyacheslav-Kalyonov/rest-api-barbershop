package com.barbershop.ru.project.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Barbershop")
@Getter
@Setter
public class Barbershop {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "region")
    private String region;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "house")
    private String house;

    @Column(name = "postal_code")
    private Integer postalCode;

    @Column(name = "phone")
    private Long phone;

    @OneToMany(mappedBy = "barbershop")
    public List<Staff> staff;

    public Barbershop() {

    }

    public Barbershop(String region, String city, String street, String house, Integer postalCode, Long phone) {
        this.region = region;
        this.city = city;
        this.street = street;
        this.house = house;
        this.postalCode = postalCode;
        this.phone = phone;
    }
}
