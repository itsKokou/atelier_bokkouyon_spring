package ism.spring.services;

import ism.spring.data.entities.Trajet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TrajetService {
    Page<Trajet> getAllTrajet(Pageable pageable);
    Trajet save (Trajet trajet);
}
