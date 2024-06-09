package ism.spring.services;

import ism.spring.data.entities.Conducteur;
import ism.spring.data.entities.Passager;

import java.util.Optional;

public interface ConducteurService {
    Conducteur save (Conducteur conducteur);
    Optional<Conducteur> show(Long id);
}
