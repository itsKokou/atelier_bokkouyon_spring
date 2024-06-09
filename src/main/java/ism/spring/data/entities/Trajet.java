package ism.spring.data.entities;

import ism.spring.data.enums.EtatTrajet;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "trajet")
@Builder
public class Trajet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String pointDepart;

    @Column(nullable=false)
    private String pointArrivee;

    @Column(nullable=false)
    private Date date;

    @Column(nullable=false)
    private Integer nbrPassagers;

    @Column(nullable=false)
    private Integer nbrPlace;

    @Column(nullable=false)
    private Double prix;

    @Enumerated(value = EnumType.STRING)
    private EtatTrajet etat;

    @ManyToOne
    private Conducteur conducteur;

    @OneToMany(mappedBy = "trajet")
    private List<Course> courses;

}
