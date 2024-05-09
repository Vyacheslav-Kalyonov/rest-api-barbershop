package com.barbershop.ru.project.dto;

import com.barbershop.ru.project.models.Staff;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BarbershopDTO {
    private int id;
    private String region;
    private String city;
    private String street;
    private String house;
    private Integer postalCode;
    private Long phone;
}
