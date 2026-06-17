package fr.eni.ludotheque.bo;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "TABLE_EXEMPLAIRE")
@NoArgsConstructor
@RequiredArgsConstructor
@Data

public class Exemplaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "no_EXEMPLAIRE")
    private Integer noExemplaire;

    @NonNull
    private String codebarre;

    @NonNull
    private boolean louable;

    @ManyToOne
    @JoinColumn(name = "no_jeu", nullable = false)
    private Jeu jeu;

}
