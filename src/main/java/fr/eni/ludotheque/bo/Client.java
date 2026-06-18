package fr.eni.ludotheque.bo;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "TABLE_CLIENT")
@NoArgsConstructor
@RequiredArgsConstructor
@Data

public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "no_client")
    private Integer noClient;

    @NonNull
    private String nom;

    @NonNull
    private String prenom;

    @NonNull
    private String email;

    @NonNull
    @Column(name = "no_telephone")
    private String noTelephone;




}
