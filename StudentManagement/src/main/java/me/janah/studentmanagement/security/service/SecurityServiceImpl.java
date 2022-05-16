package me.janah.studentmanagement.security.service;

import groovy.util.logging.Slf4j;
import lombok.AllArgsConstructor;
import me.janah.studentmanagement.security.entities.AppRole;
import me.janah.studentmanagement.security.entities.AppUser;
import me.janah.studentmanagement.security.repositories.AppRoleRepository;
import me.janah.studentmanagement.security.repositories.AppUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Slf4j
@AllArgsConstructor
@Transactional
public class SecurityServiceImpl implements ISecurityService {

    private AppUserRepository appUserRepository;
    private AppRoleRepository appRoleRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public AppUser saveNewUser(String username, String password, String rePassword) {
        if (!password.equals(rePassword)) throw new RuntimeException("Passwords do not match");
        String encodedPassword = passwordEncoder.encode(password);
        AppUser appUser = new AppUser();
        appUser.setUserId(UUID.randomUUID().toString());
        appUser.setUsername(username);
        appUser.setPassword(encodedPassword);
        appUser.setActive(true);
        return appUserRepository.save(appUser);
    }

    @Override
    public AppRole saveNewRole(String roleName, String description) {
        if (appRoleRepository.findByRoleName(roleName) != null) throw new RuntimeException("Role '"+roleName+"' already exists");
        AppRole appRole = new AppRole();
        appRole.setRoleName(roleName);
        appRole.setDescription(description);
        return appRoleRepository.save(appRole);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        AppUser appUser = appUserRepository.findByUsername(username);
        AppRole appRole = appRoleRepository.findByRoleName(roleName);
        if (appUser == null) throw new RuntimeException("User '"+username+"' does not exist");
        if (appRole == null) throw new RuntimeException("Role '"+roleName+"' does not exist");
        appUser.getAppRoles().add(appRole);
    }

    @Override
    public void removeRoleFromUser(String username, String roleName) {
        AppUser appUser = appUserRepository.findByUsername(username);
        AppRole appRole = appRoleRepository.findByRoleName(roleName);
        if (appUser == null) throw new RuntimeException("User '"+username+"' does not exist");
        if (appRole == null) throw new RuntimeException("Role '"+roleName+"' does not exist");
        appUser.getAppRoles().remove(appRole);
    }

    @Override
    public AppUser loadUserByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }
}
