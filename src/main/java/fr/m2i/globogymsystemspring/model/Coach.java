package fr.m2i.globogymsystemspring.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="coach")
@Data
public class Coach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nom;

    @Column
    private String prenom;
}
