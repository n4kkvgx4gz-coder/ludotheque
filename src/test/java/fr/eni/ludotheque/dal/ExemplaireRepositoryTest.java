package fr.eni.ludotheque.dal;


import fr.eni.ludotheque.bo.Client;
import fr.eni.ludotheque.bo.Exemplaire;
import fr.eni.ludotheque.bo.Genre;
import fr.eni.ludotheque.bo.Jeu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ExemplaireRepositoryTest {

    @Autowired
    JeuRepository jeuRepository;
    @Autowired
    GenreRepository genreRepository;

    @Autowired
    private ExemplaireRepository exemplaireRepository;


    @Test
    @DisplayName("Test positif d'ajout d'exemplaire")
        //@Transactional //Rollback = retour en arrière annule l'insert crée en test
    void testExemplaireRepository() {

        //Arrange

        Genre genre = new Genre();
        genre.setLibelle("Famille");
        Genre genreBD = genreRepository.save(genre);

        Jeu jeu = new Jeu();
        jeu.setTitre("Uno");
        jeu.setReference("UNO001");
        jeu.setDescription("Jeu de cartes");
        jeu.setAgeMin(7);
        jeu.setDuree(10);
        jeu.setTarifJour(2);
        jeu.getGenres().add(genreBD);

        Jeu jeuBD = jeuRepository.save(jeu);


        Exemplaire exemplaire = new Exemplaire();
        exemplaire.setCodebarre("12345678899");
        exemplaire.setLouable(true);
        exemplaire.setJeu(jeuBD);


        // Act = je l'enregistre en base
        Exemplaire exemplaireBD = exemplaireRepository.save(exemplaire);

        // Assert = je vérifie qu'il existe bien en base

        assertThat(exemplaireBD).isNotNull();
        assertThat(exemplaireBD.getNoExemplaire()).isNotNull();
        assertThat(exemplaireBD.getCodebarre()).isEqualTo("12345678899");
        assertThat(exemplaireBD.isLouable()).isTrue();
        assertThat(exemplaireBD.getJeu().getNoJeu()).isEqualTo(jeuBD.getNoJeu());

    }


}
