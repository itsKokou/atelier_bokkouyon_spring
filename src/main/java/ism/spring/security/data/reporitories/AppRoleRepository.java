package ism.spring.security.data.reporitories;

import ism.spring.data.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AppRoleRepository extends JpaRepository<AppRole,Long> {
    AppRole getByRoleName(String roleName);
}
