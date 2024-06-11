package chakaChatApp.chaka.Service;

import chakaChatApp.chaka.Entity.Message;

import java.util.List;
import java.util.Optional;

public interface MessageService {
    List<Message> getAllMessages();
    Optional<Message> getMessageById(Long messageId);
    Message createMessage(Message message);
    Message updateMessage(Long messageId, Message messageDetails);
    void deleteMessage(Long messageId);
}