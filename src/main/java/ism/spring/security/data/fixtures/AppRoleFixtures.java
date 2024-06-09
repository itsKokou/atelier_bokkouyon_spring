package ism.spring.security.data.fixtures;


import ism.spring.security.services.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Component
//@Order(1)
@RequiredArgsConstructor

public class AppRoleFixtures implements CommandLineRunner {
   private final SecurityService securityService;
    @Override
    public void run(String... args) throws Exception {
          securityService.saveRole("ROLE_ADMIN");
          securityService.saveRole("ROLE_CONDUCTEUR");
          securityService.saveRole("ROLE_PASSAGER");

    }
}
