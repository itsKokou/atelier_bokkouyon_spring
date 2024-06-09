package ism.spring.data.fixtures;

import ism.spring.data.entities.AppRole;
import ism.spring.data.entities.Conducteur;
import ism.spring.data.entities.Passager;
import ism.spring.security.services.SecurityService;
import ism.spring.services.ConducteurService;
import ism.spring.services.PassagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

//@Component
//@Order(4)
@RequiredArgsConstructor
public class ConducteurFixtures implements CommandLineRunner {
    private final ConducteurService conducteurService;
    private final PasswordEncoder passwordEncoder;
    private final SecurityService securityService;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 1; i <= 4; i++) {
            Conducteur conducteur = new Conducteur();
            conducteur.setLogin("conducteur"+i+"@gmail.com");
            conducteur.setPassword(passwordEncoder.encode("passer"));
            conducteur.setNomComplet("Le conducteur "+i);
            conducteur.setTelephone("77781401"+i);

            AppRole role = securityService.getRoleByName("ROLE_CONDUCTEUR");

            conducteur.setRoles(new ArrayList<>());
            conducteur.getRoles().add(role);

            conducteurService.save(conducteur);
        }

    }
}