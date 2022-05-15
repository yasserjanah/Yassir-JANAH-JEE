package me.janah.usersandroles;

import me.janah.usersandroles.entities.Role;
import me.janah.usersandroles.entities.User;
import me.janah.usersandroles.services.IUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@SpringBootApplication
public class UsersAndRolesApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsersAndRolesApplication.class, args);
    }

    @Bean
    CommandLineRunner init(IUserService userService) {
        return args -> {
            Role roleAdmin = new Role();
            roleAdmin.setRoleName("ADMIN");
            roleAdmin.setDescription("Administrator");
            userService.addNewRole(roleAdmin);

            Role roleUser = new Role();
            roleUser.setRoleName("USER");
            roleUser.setDescription("User");
            userService.addNewRole(roleUser);

            User userAdmin = new User();
            userAdmin.setUsername("admin");
            userAdmin.setPassword("admin");
            userService.addNewUser(userAdmin);

            User userUser = new User();
            userUser.setUsername("user");
            userUser.setPassword("user");
            userService.addNewUser(userUser);

            userService.addRoleToUser("USER", "user");
            userService.addRoleToUser("ADMIN", "admin");
            userService.addRoleToUser("USER", "admin");

        };
    }

}
