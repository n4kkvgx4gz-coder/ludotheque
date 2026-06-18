package fr.eni.ludotheque.dal;

import fr.eni.ludotheque.bo.Client;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ClientRepositoryTest {

    @Autowired
    private ClientRepository clientRepository;

    @Test
    @DisplayName("Test positif de création d'un client en BD")
    //@Transactional //Rollback = retour en arrière annule l'insert crée en test
    public void testInsertClient() {

        // Arrange = je prépare un client
        Client client = new Client();
        client.setNom("Martin");
        client.setPrenom("Martin");
        client.setEmail("martin.martin@gmail.com");
        client.setNoTelephone("0600000000");

        // Act = je l'enregistre en base
        Client clientBD = clientRepository.save(client);

        // Assert = je vérifie qu'il existe bien en base
        Client clientEnBD = clientRepository.findById(clientBD.getNoClient()).orElse(null);

        assertThat(clientEnBD).isNotNull();
        assertThat(clientEnBD.getNoClient()).isNotNull();
        assertThat(clientEnBD.getNom()).isEqualTo("Martin");
        assertThat(clientEnBD.getPrenom()).isEqualTo("Martin");
        assertThat(clientEnBD.getEmail()).isEqualTo("martin.martin@gmail.com");
        assertThat(clientEnBD.getNoTelephone()).isEqualTo("0600000000");
    }
}