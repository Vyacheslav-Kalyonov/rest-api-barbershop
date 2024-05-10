package com.barbershop.ru.project.exception.staff;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StaffErrorResponse {
    private String msg;
    private long timestamp;
}
