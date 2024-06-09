package ism.spring.security.data.fixtures;

import ism.spring.data.entities.AppUser;
import ism.spring.security.services.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

//@Component
//@Order(2)
@RequiredArgsConstructor

public class AppUserFixtures implements CommandLineRunner {
   private final SecurityService securityService;
   private final PasswordEncoder passwordEncoder;
    @Override
    public void run(String... args) throws Exception {
        AppUser appUser = AppUser.builder()
                .login("admin@gmail.com")
                .password(passwordEncoder.encode("passer"))
                .nomComplet("Kokou Godwin")
                .telephone("778159024")
                .build();
        securityService.saveUser(appUser);
        securityService.addRoleToUser("admin@gmail.com","ROLE_ADMIN");
    }
}
