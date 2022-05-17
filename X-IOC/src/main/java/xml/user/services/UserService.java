package xml.user.services;

import lombok.AllArgsConstructor;
import xml.user.entities.User;
import xml.user.repositories.IUserRepository;

public class UserService {

    private IUserRepository userRepository;

    public User findUserByName(String name) {
        return userRepository.findUserByUsername(name);
    }

    // setter injection
    public void setUserRepository(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

}
