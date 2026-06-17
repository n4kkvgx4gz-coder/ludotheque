package fr.eni.ludotheque.bo;

import jakarta.persistence.*;
//import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "TABLE_JEU")
@NoArgsConstructor
@RequiredArgsConstructor
@Data

public class Jeu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "identifiant")
    private Integer noJeu;

    @NonNull
    private String titre;

    @NonNull
    private String reference;

    //@Min(0)
    @Column(name = "age_min")
    private int ageMin;

    private String description;

    //@Min(1)
    private int duree;

    @NonNull
    @Column(name = "tarif_jour")
    private int tarifJour;

    @ManyToOne
    @JoinColumn(name = "no_genre", nullable = false)
    private Genre genre;



}
