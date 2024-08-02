package chakaChatApp.chaka.Service;

import chakaChatApp.chaka.Entity.ChatRoom;
import chakaChatApp.chaka.Entity.Message;

import java.util.List;

public interface RandomStringService {
    String generateRandomString();
    String generateSecureRandomString();
}
