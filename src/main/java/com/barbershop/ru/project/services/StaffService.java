package com.barbershop.ru.project.services;

import com.barbershop.ru.project.models.Staff;
import com.barbershop.ru.project.repositories.StaffRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {

    private final StaffRepository staffRepository;

    @Autowired
    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @Transactional
    public List<Staff> findAll() {
        return staffRepository.findAll();
    }

    @Transactional
    public Staff findOne(int id) {
        return staffRepository.findById(id).orElse(null);
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
    public List<Staff> findAllByBarbershopId(int id) {
        return staffRepository.findAllByBarbershopId(id);
    }

    @Transactional
    public List<Staff> findAllMastersByBarbershopId(int id) {
        return staffRepository.findAllByPositionIsTrue();
    }
}
