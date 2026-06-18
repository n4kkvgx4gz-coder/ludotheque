package fr.eni.ludotheque.bll;

import fr.eni.ludotheque.dal.ClientRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import fr.eni.ludotheque.bo.Client;


@ExtendWith(MockitoExtension.class)
public class ClientServiceRechercheNomTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientServiceImpl clientService;

    @Test
    void testClientMar() {

        //Arrange

        Client client1 = new Client();
        client1.setNom("Martin");

        Client client2 = new Client();
        client2.setNom("Mars");

        Client client3 = new Client();
        client3.setNom("Martinez");

        List<Client> listeClients = List.of(client1, client2, client3);

        when(clientRepository.findByNomStartsWith("Mar"))
                .thenReturn(listeClients);

        //Act
        List<Client> resultat = clientService.rechercherParNom("Mar");


        //Arrange
        assertThat(resultat).hasSize(3);

    }
}