package fr.m2i.globogymsystemspring.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="cours")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nom;

    @Column
    private Date date;

    @ManyToOne
    @JoinColumn(name="coach_id")
    private Coach coach;

    @ManyToMany(mappedBy = "cours", fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })

    private List<Client> clients = new ArrayList<>();

}
