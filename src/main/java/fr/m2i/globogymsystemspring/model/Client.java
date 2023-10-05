package fr.m2i.globogymsystemspring.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table (name="client")
@Data
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nom;

    @Column
    private String prenom;
}
