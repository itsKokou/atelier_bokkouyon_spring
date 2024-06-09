package ism.spring.services.impl;

import ism.spring.data.entities.Conducteur;
import ism.spring.data.repositories.ConducteurRepository;
import ism.spring.services.ConducteurService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ConducteurServiceImpl implements ConducteurService {
    private final ConducteurRepository conducteurRepository;

    @Override
    public Conducteur save(Conducteur conducteur) {
        return conducteurRepository.save(conducteur);
    }

    @Override
    public Optional<Conducteur> show(Long id) {
        return conducteurRepository.findById(id);
    }
}
