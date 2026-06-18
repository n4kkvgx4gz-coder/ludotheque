package fr.eni.ludotheque.bll;

import fr.eni.ludotheque.bo.Client;
import fr.eni.ludotheque.dal.ClientRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class ClientServiceTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientServiceImpl clientService;

    @Test
    void testAjoutClient() {

        //Arrange
        Client client = new Client();
        client.setNom("Martin");
        client.setPrenom("Martin");
        client.setEmail("martin.martin@gmail.com");
        client.setNoTelephone("0600000000");

        //Act
        clientRepository.save(client);

        //Assert
        Mockito.verify(clientRepository).save(client);
    }

}
