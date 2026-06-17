package fr.eni.ludotheque;

import fr.eni.ludotheque.bo.Client;
import fr.eni.ludotheque.dal.ClientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class ClientServiceTest {

    @Autowired
    private ClientRepository clientService;


    @Test
    void testInvertClient() {


        //Arrange

        Client client = new Client();
        client.setNom("Martin");
        client.setPrenom("Martin");
        client.setEmail("martin.martin@gmail.com");
        client.setNoTelephone("0600000000");
        // Act
        Client clientBdd = clientService.save(client);

        // Assert
        assertThat(clientBdd).isNotNull();
        assertThat(clientBdd.getNoClient()).isNotNull();
        assertThat(clientBdd.getNom()).isEqualTo("Martin");




    }



}
