package ism.spring.data.fixtures;

import ism.spring.data.entities.AppRole;
import ism.spring.data.entities.Conducteur;
import ism.spring.data.entities.Trajet;
import ism.spring.data.enums.EtatTrajet;
import ism.spring.security.services.SecurityService;
import ism.spring.services.ConducteurService;
import ism.spring.services.TrajetService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;

//@Component
//@Order(5)
@RequiredArgsConstructor
public class TrajetFixtures implements CommandLineRunner {
    private final TrajetService trajetService;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 1; i <= 8; i++) {
            Trajet trajet = new Trajet();
            trajet.setDate(new Date());
            trajet.setEtat(EtatTrajet.Restant);
            trajet.setPrix(200.0);
            trajet.setNbrPassagers(1);
            trajet.setNbrPlace(3);
            trajet.setPointDepart("Medina");
            trajet.setPointArrivee("Thies");

            trajetService.save(trajet);
        }

    }
}