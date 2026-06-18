package fr.eni.ludotheque.dal;

import fr.eni.ludotheque.bo.Genre;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SpringBootTest
public class GenreRepositoryTest {

    @Autowired
    private GenreRepository genreRepository;

    @Test
    @DisplayName("Test positif de création d'un genre en BD")
    //@Transactional //Rollback = retour en arrière annule l'insert crée en test
    public void testInsertGenre() {

        // Arrange = je prépare un client
        Genre genre = new Genre();
        genre.setLibelle("Loisir");

        // Act = je l'enregistre en base

        Genre genreBD = genreRepository.save(genre);

        // Assert = je vérifie qu'il existe bien en base

        Genre genreEnBD = genreRepository.findById(genreBD.getNoGenre()).orElse(null);

        assertThat(genreEnBD).isNotNull();
        assertThat(genreEnBD.getNoGenre()).isNotNull();
        assertThat(genreEnBD.getLibelle()).isEqualTo("Loisir");
    }

}
