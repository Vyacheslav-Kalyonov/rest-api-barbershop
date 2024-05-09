package com.barbershop.ru.project.repositories;

import com.barbershop.ru.project.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    Client findByPhoneOrMail(long number, String mail);
}
