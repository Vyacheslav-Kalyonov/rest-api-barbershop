package com.barbershop.ru.project.exception.barbershop;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BarbershopErrorResponse {
    private String msg;
    private long timestamp;
}
