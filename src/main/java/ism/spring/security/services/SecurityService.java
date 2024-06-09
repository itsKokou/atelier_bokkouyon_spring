package ism.spring.security.services;


import ism.spring.data.entities.AppRole;
import ism.spring.data.entities.AppUser;

import java.util.Optional;

public interface SecurityService {
    AppUser getUserByUsername(String username);
    Optional<AppUser> getUserById(Long id);
    AppUser saveUser(AppUser user);
    AppRole saveRole(String roleName);
    AppRole getRoleByName(String roleName);
    void addRoleToUser(String username,String roleName);
    void removeRoleToUser(String username,String roleName);
}
