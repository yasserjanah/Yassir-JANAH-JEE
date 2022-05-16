package me.janah.studentmanagement.security.service;

import me.janah.studentmanagement.security.entities.AppRole;
import me.janah.studentmanagement.security.entities.AppUser;

public interface ISecurityService {
    AppUser saveNewUser(String username, String password, String rePassword);
    AppRole saveNewRole(String roleName, String description);
    void addRoleToUser(String username, String roleName);
    void removeRoleFromUser(String username, String roleName);
    AppUser loadUserByUsername(String username);

}
