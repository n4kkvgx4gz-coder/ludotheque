package fr.eni.ludotheque.dal;

import fr.eni.ludotheque.bo.Adresse;
import fr.eni.ludotheque.bo.Client;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
public class ClientAdresseRepositoryTest {

    @Autowired
    private AdresseRepository adresseRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Test
    //@Transactional //Rollback = retour en arrière annule l'insert crée en test
    void testInsertClientAdresse() {

        //Arrange

        //
        Client client = new Client();
        client.setNom("Martin");
        client.setPrenom("Martin");
        client.setEmail("martin.martin@gmail.com");
        client.setNoTelephone("0600000000");

        //

        Client clientBD = clientRepository.save(client);

        Adresse adresse = new Adresse();
        adresse.setRue("10 rue des Lilas");
        adresse.setCodePostal("29000");
        adresse.setVille("Quimper");

        adresse.setClient(clientBD);


        // Act
        Adresse adresseBD = adresseRepository.save(adresse);


        // Assert
        assertThat(adresseBD).isNotNull();
        assertThat(adresseBD.getNoAdresse()).isNotNull();
        assertThat(adresseBD.getRue()).isEqualTo("10 rue des Lilas");
        assertThat(adresseBD.getCodePostal()).isEqualTo("29000");
        assertThat(adresseBD.getVille()).isEqualTo("Quimper");

        assertThat(adresseBD.getClient()).isNotNull();
        assertThat(adresseBD.getClient().getNoClient()).isEqualTo(clientBD.getNoClient());
    }
}
