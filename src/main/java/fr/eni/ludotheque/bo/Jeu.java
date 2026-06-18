package fr.eni.ludotheque.bo;

import jakarta.persistence.*;
//import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToMany
    @JoinTable(
            name = "TABLE_JEU_GENRE",
            joinColumns = @JoinColumn(name = "no_jeu"),
            inverseJoinColumns = @JoinColumn(name = "no_genre")
    )
    private List<Genre> genres = new ArrayList<>();


}
