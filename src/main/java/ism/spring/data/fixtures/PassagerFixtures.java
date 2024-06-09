package ism.spring.data.fixtures;

import ism.spring.data.entities.AppRole;
import ism.spring.data.entities.AppUser;
import ism.spring.data.entities.Passager;
import ism.spring.security.services.SecurityService;
import ism.spring.services.PassagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

//@Component
//@Order(3)
@RequiredArgsConstructor
public class PassagerFixtures implements CommandLineRunner {
    private final PassagerService passagerService;
    private final PasswordEncoder passwordEncoder;
    private final SecurityService securityService;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 1; i <= 6; i++) {
            Passager passager = new Passager();
            passager.setLogin("passager"+i+"@gmail.com");
            passager.setPassword(passwordEncoder.encode("passer"));
            passager.setNomComplet("Le passager "+i);
            passager.setTelephone("78815902"+i);

            AppRole role = securityService.getRoleByName("ROLE_PASSAGER");

            passager.setRoles(new ArrayList<>());
            passager.getRoles().add(role);

            passagerService.save(passager);
        }

    }
}