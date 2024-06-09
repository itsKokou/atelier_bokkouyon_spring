package ism.spring.services;

import ism.spring.data.entities.Conducteur;
import ism.spring.data.entities.Trajet;
import ism.spring.data.enums.EtatTrajet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TrajetService {
    Page<Trajet> getAllTrajet(Pageable pageable);
    Page<Trajet> getAllByEtatAndConducteur(Conducteur conducteur, EtatTrajet etat, Pageable pageable);
    Trajet save (Trajet trajet);
}
