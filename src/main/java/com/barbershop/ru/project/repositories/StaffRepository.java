package com.barbershop.ru.project.repositories;

import com.barbershop.ru.project.models.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer> {

    List<Staff> findAllByBarbershopId(int id);
}
