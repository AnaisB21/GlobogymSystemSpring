package fr.m2i.globogymsystemspring.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name="client")
@Getter
@Setter
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nom;

    @Column
    private String prenom;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "reservation", joinColumns = @JoinColumn(name="client_id"), inverseJoinColumns = @JoinColumn(name="cours_id"))
    private List<Cours> cours =new ArrayList<>();;

}
