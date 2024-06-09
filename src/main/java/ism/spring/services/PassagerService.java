package ism.spring.services;

import ism.spring.data.entities.Conducteur;
import ism.spring.data.entities.Passager;

import java.util.Optional;

public interface PassagerService {
    Passager save (Passager passager);
    Optional<Passager> show(Long id);
}
