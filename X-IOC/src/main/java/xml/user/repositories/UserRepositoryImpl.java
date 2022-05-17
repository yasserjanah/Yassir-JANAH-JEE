package xml.user.repositories;

import xml.user.entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements IUserRepository {

    private final List<User> users = new ArrayList<>();

    public UserRepositoryImpl() {
        users.add(new User(1L, "user1"));
        users.add(new User(2L, "user2"));
        users.add(new User(3L, "user3"));
    }

    @Override
    public User findUserByUsername(String name) {
        return users.stream()
                .filter(user -> user.getName().equals(name))
                .findFirst().orElse(null);
    }
}
