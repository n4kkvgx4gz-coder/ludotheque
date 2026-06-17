package fr.eni.ludotheque.bo;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "TABLE_LOCATION")
@NoArgsConstructor
@RequiredArgsConstructor
@Data

public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "no_location")
    private Integer noLocation;

    @NonNull
    @Column(name = "date_debut", nullable = false)
    private LocalDate dateDebut;

    @Column(name = "date_retour")
    private LocalDate dateRetour;


    @NonNull
    @Column(name = "tarif_jour")
    private int tarifJour;


    @ManyToOne
    @JoinColumn(name = "no_client", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "no_exemplaire", nullable = false)
    private Exemplaire exemplaire;

}
