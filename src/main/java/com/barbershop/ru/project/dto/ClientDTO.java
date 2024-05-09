package com.barbershop.ru.project.dto;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {

    private String name;
    private String surname;
    private Long phone;
    private String mail;
}
