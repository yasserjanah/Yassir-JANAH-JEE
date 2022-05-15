package me.janah.usersandroles.services;

import lombok.AllArgsConstructor;
import me.janah.usersandroles.entities.Role;
import me.janah.usersandroles.entities.User;
import me.janah.usersandroles.repositories.RoleRepository;
import me.janah.usersandroles.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements IUserService{

    private UserRepository userRepository;

    private RoleRepository roleRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void addNewUser(User user) {
        user.setId(UUID.randomUUID().toString());
        userRepository.save(user);
    }

    @Override
    public void addNewRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Role findRoleByRoleName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }

    @Override
    public void addRoleToUser(String roleName, String username) {
        User user = this.findUserByUsername(username);
        Role role = this.findRoleByRoleName(roleName);
        // check if user has no roles
        if (user.getRoles() == null) {
            throw new IllegalArgumentException("User has no roles");
        }
        user.getRoles().add(role);
        role.getUsers().add(user);
    }

    @Override
    public String authenticate(String username, String password) {
        User user = this.findUserByUsername(username);
        if (user == null) {
            return ("Invalid username/password");
        }
        if (!user.getPassword().equals(password)) {
            return ("Invalid username/password");
        }
        return "Hello " + user.getUsername();
    }
}
