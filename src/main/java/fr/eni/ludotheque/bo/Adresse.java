package fr.eni.ludotheque.bo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TABLE_ADRESSE")
@NoArgsConstructor
@RequiredArgsConstructor
@Data

public class Adresse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    @Column(name = "no_adresse")
    private Integer noAdresse;

    @NonNull
    private String rue;


    @Column(name = "code_postal", length = 6, nullable = false)
    @NonNull
    private String codePostal;

    @Column(length = 100, nullable = false)
    @NonNull
    private String ville;

    @OneToOne
    @JoinColumn(name = "no_client", nullable = false)
    private Client client;

}