package me.janah.usersandroles.web;

import lombok.AllArgsConstructor;
import me.janah.usersandroles.entities.User;
import me.janah.usersandroles.services.IUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {

    private IUserService userService;

    @RequestMapping("/users")
    public List<User> index() {
        return userService.findAll();
    }

    @RequestMapping("/users/{username}")
    public User users(@PathVariable String username) {
        return userService.findUserByUsername(username);
    }

    @RequestMapping(value = "/users/authenticate", method = RequestMethod.POST)
    public String authenticate(@RequestParam String username, @RequestParam String password) {
        return userService.authenticate(username, password);
    }
}
