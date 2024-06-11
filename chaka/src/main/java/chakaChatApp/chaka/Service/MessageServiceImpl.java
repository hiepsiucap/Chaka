package chakaChatApp.chaka.Service;

import chakaChatApp.chaka.Entity.Message;
import chakaChatApp.chaka.Respository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    @Override
    public Optional<Message> getMessageById(Long messageId) {
        return messageRepository.findById(messageId);
    }

    @Override
    public Message createMessage(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public Message updateMessage(Long messageId, Message messageDetails) {
        Optional<Message> messageOptional = messageRepository.findById(messageId);
        if (messageOptional.isPresent()) {
            Message message = messageOptional.get();
            message.setMessageText(messageDetails.getMessageText());
            message.setSentAt(messageDetails.getSentAt());
            return messageRepository.save(message);
        } else {
            throw new RuntimeException("Message not found with id: " + messageId);
        }
    }

    @Override
    public void deleteMessage(Long messageId) {
        messageRepository.deleteById(messageId);
    }
}
