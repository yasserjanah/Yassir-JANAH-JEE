package annotations.user.services;

import annotations.XAutowired;
import annotations.user.entities.User;
import annotations.user.repositories.IUserRepository;

public class UserService {

    @XAutowired
    private IUserRepository userRepository;

    public User findUserByName(String name) {
        return userRepository.findUserByUsername(name);
    }

    // setter injection
    public void setUserRepository(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

}
