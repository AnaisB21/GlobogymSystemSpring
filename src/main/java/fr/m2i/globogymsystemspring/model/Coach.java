package fr.m2i.globogymsystemspring.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="coach")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Coach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nom;

    @Column
    private String prenom;

    @OneToMany(mappedBy = "coach", cascade=CascadeType.ALL)
    private List<Cours> listCours = new ArrayList<>();

}
