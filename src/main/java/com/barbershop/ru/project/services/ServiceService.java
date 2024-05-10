package com.barbershop.ru.project.services;

import com.barbershop.ru.project.exception.service.ServiceNotFoundException;
import com.barbershop.ru.project.repositories.ServiceRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceService {

    private final ServiceRepository serviceRepository;

    @Autowired
    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Transactional
    public List<com.barbershop.ru.project.models.Service> findAll() {
        return serviceRepository.findAll();
    }

    @Transactional
    public com.barbershop.ru.project.models.Service findOne(int id) {
        return serviceRepository.findById(id).orElseThrow(ServiceNotFoundException::new);
    }

    @Transactional
    public void save(com.barbershop.ru.project.models.Service service) {
        serviceRepository.save(service);
    }

    @Transactional
    public void delete(int id) {
        serviceRepository.deleteById(id);
    }

    @Transactional
    public void update(int id, com.barbershop.ru.project.models.Service service) {
        service.setId(id);
        serviceRepository.save(service);
    }
}
