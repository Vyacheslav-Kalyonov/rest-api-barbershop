package com.barbershop.ru.project.services;

import com.barbershop.ru.project.models.Appointment;
import com.barbershop.ru.project.models.Client;
import com.barbershop.ru.project.repositories.AppointmentRepository;
import com.barbershop.ru.project.repositories.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Transactional
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Transactional
    public Client findOne(int id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Transactional
    public void save(Client client) {
        clientRepository.save(client);
    }

    @Transactional
    public void delete(int id) {
        clientRepository.deleteById(id);
    }

    @Transactional
    public void update(int id, Client updatedClient) {
        updatedClient.setId(id);
        clientRepository.save(updatedClient);
    }

    @Transactional
    public Client findByPhone(long number, String mail) {
        return clientRepository.findByPhoneOrMail(number, mail);
    }
}
