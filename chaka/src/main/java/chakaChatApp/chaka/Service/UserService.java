package chakaChatApp.chaka.Service;

import chakaChatApp.chaka.Entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();
    Optional<User> getUserById(Long userId);
    Optional<User> getUserByUsername(String username);
    User createUser(User user);
    User updateUser(Long userId, User userDetails);
    void deleteUser(Long userId);
}
