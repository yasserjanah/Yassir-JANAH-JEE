package me.janah.usersandroles.services;

import me.janah.usersandroles.entities.Role;
import me.janah.usersandroles.entities.User;

import java.util.List;

public interface IUserService {

    List<User> findAll();
    void addNewUser(User user);
    void addNewRole(Role role);
    User findUserByUsername(String username);
    Role findRoleByRoleName(String roleName);
    void addRoleToUser(String roleName, String username);
    String authenticate(String username, String password);
}