package chakaChatApp.chaka.Service;

import chakaChatApp.chaka.DTO.ChatRoomDTO;
import chakaChatApp.chaka.Entity.ChatRoom;
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
    List<ChatRoomDTO> getRoomsForUser(Long userId);
    User getCurrentUser();
}
