package annotations.user.repositories;

import annotations.user.entities.User;

public interface IUserRepository {
    User findUserByUsername(String username);
}
