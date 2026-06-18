package fr.eni.ludotheque.dal;


import fr.eni.ludotheque.bo.Genre;
import fr.eni.ludotheque.bo.Jeu;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class JeuGenreRepositoryTest {


    @Autowired
    private JeuRepository jeuRepository;

    @Autowired
    private GenreRepository genreRepository;


    @Test
    //@Transactional //Rollback = retour en arrière annule l'insert crée en test
    void testJeuGenreRepository() {

        //Arrange

        Genre genreFamille = new Genre();
        genreFamille.setLibelle("Famille");
        Genre genreFamilleBD = genreRepository.save(genreFamille);

        Genre genreStratege = new Genre();
        genreStratege.setLibelle("Strategie");
        Genre genreStrategieBD = genreRepository.save(genreStratege);

        Jeu jeu = new Jeu();
        jeu.setTitre("Uno");
        jeu.setDuree(10);
        jeu.setReference("AV123456789");
        jeu.setDescription("Jeu de cartes ...");
        jeu.setAgeMin(12);
        jeu.setTarifJour(2);

        jeu.getGenres().add(genreFamilleBD);
        jeu.getGenres().add(genreStrategieBD);

        // ACT

        Jeu jeuBD = jeuRepository.save(jeu);

        // Assert


        assertThat(jeuBD).isNotNull();
        assertThat(jeuBD.getNoJeu()).isNotNull();
        assertThat(jeuBD.getTitre()).isEqualTo("Uno");
        assertThat(jeuBD.getGenres()).hasSize(2);

    }
}
