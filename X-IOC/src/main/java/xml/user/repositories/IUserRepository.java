package xml.user.repositories;

import xml.user.entities.User;

public interface IUserRepository {
    User findUserByUsername(String username);
}
