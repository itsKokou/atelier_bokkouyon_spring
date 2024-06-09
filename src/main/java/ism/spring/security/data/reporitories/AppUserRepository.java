package ism.spring.security.data.reporitories;

import ism.spring.data.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,Long> {
      AppUser findByLogin(String login);
}
