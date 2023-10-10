package fr.m2i.globogymsystemspring.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;


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

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name="coach_id")
    private Coach coach;

    //@JoinTable avec réservation comme table de jointure cours id, client id
}
