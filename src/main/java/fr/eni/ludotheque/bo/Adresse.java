package fr.eni.ludotheque.bo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "TABLE_ADRESSE")
@NoArgsConstructor
@RequiredArgsConstructor
@Data

public class Adresse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "no_adresse")
    private Integer noAdresse;

    @NonNull
    private String rue;

    @NonNull
    @Column(name = "code_postal", length = 6)
    private String codePostal;

    @NonNull
    private String ville;

    @OneToOne
    @JoinColumn(name = "no_client", nullable = false)
    private Client client;

}