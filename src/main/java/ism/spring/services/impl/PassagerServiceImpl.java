package ism.spring.services.impl;

import ism.spring.data.entities.Conducteur;
import ism.spring.data.entities.Passager;
import ism.spring.data.repositories.PassagerRepository;
import ism.spring.services.PassagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PassagerServiceImpl implements PassagerService {
    private final PassagerRepository passagerRepository;

    @Override
    public Passager save(Passager passager) {
        return passagerRepository.save(passager);
    }

    @Override
    public Optional<Passager> show(Long id) {
        return passagerRepository.findById(id);
    }
}
