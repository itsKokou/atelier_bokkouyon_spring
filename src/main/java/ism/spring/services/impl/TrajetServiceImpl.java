package ism.spring.services.impl;

import ism.spring.data.entities.Trajet;
import ism.spring.data.repositories.TrajetRepository;
import ism.spring.services.TrajetService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class TrajetServiceImpl implements TrajetService {
    private final TrajetRepository trajetRepository;

    @Override
    public Page<Trajet> getAllTrajet(Pageable pageable) {
        return trajetRepository.findAll(pageable);
    }

    @Override
    public Trajet save(Trajet trajet) {
        return trajetRepository.save(trajet);
    }
}
