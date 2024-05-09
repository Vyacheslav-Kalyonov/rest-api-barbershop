package com.barbershop.ru.project.repositories;

import com.barbershop.ru.project.models.Client;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;



@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class ClientRepositoryTest {

    @Autowired
    private ClientRepository clientRepository;

    @Test
    public void clientRepository_save_returnTrue() {
        // Arrange
        Client client = new Client("Slava", "Kalenov", 89807561216L, "test@mail.ru");

        // Act

        clientRepository.save(client);

        // Assert
        Assertions.assertNotNull(client);
        Assertions.assertTrue(client.getId() > 0);
    }
}