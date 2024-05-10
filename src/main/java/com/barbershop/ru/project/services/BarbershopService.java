package com.barbershop.ru.project.services;

import com.barbershop.ru.project.models.Barbershop;
import com.barbershop.ru.project.repositories.BarbershopRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarbershopService {

    private final BarbershopRepository barbershopRepository;

    @Autowired
    public BarbershopService(BarbershopRepository barbershopRepository) {
        this.barbershopRepository = barbershopRepository;
    }

    @Transactional
    public List<Barbershop> findAll() {
        return barbershopRepository.findAll();
    }

    @Transactional
    public Barbershop findOne(int id) {
        return barbershopRepository.findById(id).orElse(null);
    }

    @Transactional
    public void save(Barbershop barbershop) {
        barbershopRepository.save(barbershop);
    }

    @Transactional
    public void delete(int id) {
        barbershopRepository.deleteById(id);
    }

    @Transactional
    public void update(int id, Barbershop updatedBarbershop) {
        updatedBarbershop.setId(id);
        barbershopRepository.save(updatedBarbershop);
    }

    @Transactional
    public boolean existById(int id) {
        return barbershopRepository.existsById(id);
    }
}
