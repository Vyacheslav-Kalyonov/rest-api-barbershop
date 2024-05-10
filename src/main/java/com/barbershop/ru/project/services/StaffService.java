package com.barbershop.ru.project.services;

import com.barbershop.ru.project.exception.barbershop.BarbershopNotFoundException;
import com.barbershop.ru.project.exception.staff.StaffNotFoundException;
import com.barbershop.ru.project.models.Staff;
import com.barbershop.ru.project.repositories.StaffRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {

    private final StaffRepository staffRepository;
    private final BarbershopService barbershopService;

    @Autowired
    public StaffService(StaffRepository staffRepository, BarbershopService barbershopService) {
        this.staffRepository = staffRepository;
        this.barbershopService = barbershopService;
    }

    @Transactional
    public List<Staff> findAll() {
        return staffRepository.findAll();
    }

    @Transactional
    public Staff findOne(int id) {
        return staffRepository.findById(id).orElseThrow(StaffNotFoundException::new);
    }

    @Transactional
    public void save(Staff staff) {
        staffRepository.save(staff);
    }

    @Transactional
    public void delete(int id) {
        staffRepository.deleteById(id);
    }

    @Transactional
    public void update(int id, Staff updatedStaff) {
        updatedStaff.setId(id);
        staffRepository.save(updatedStaff);
    }

    @Transactional
    public List<Staff> findAllMastersByBarbershopId(int id) {
        if (!barbershopService.existById(id)) {
            throw new BarbershopNotFoundException();
        }

        return staffRepository.findAllByBarbershopId(id).stream()
                .filter(staff -> staff.getPosition()
                        .getHasAcceptAppointments() == Boolean.TRUE).toList();
    }

    @Transactional
    public boolean existById(int id) {
        return staffRepository.existsById(id);
    }
}
