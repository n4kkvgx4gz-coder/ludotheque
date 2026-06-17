package fr.eni.ludotheque.bo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "TABLE_FACTURE")
@NoArgsConstructor
@RequiredArgsConstructor
@Data

public class Facture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "no_facture")
    private Integer noFacture;

    @NonNull
    @Column(name = "date_paiement", nullable = false)
    private LocalDate datePaiement;

    @OneToOne
    @Column(name = "no_location", nullable = false)
    private Location location;
}