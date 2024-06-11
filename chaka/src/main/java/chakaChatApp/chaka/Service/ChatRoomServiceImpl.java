package chakaChatApp.chaka.Service;

import chakaChatApp.chaka.Entity.ChatRoom;
import chakaChatApp.chaka.Respository.ChatRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChatRoomServiceImpl implements ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;

    @Autowired
    public ChatRoomServiceImpl(ChatRoomRepository chatRoomRepository) {
        this.chatRoomRepository = chatRoomRepository;
    }

    @Override
    public List<ChatRoom> getAllChatRooms() {
        return chatRoomRepository.findAll();
    }

    @Override
    public Optional<ChatRoom> getChatRoomById(Long roomId) {
        return chatRoomRepository.findById(roomId);
    }

    @Override
    public ChatRoom createChatRoom(ChatRoom chatRoom) {
        return chatRoomRepository.save(chatRoom);
    }

    @Override
    public ChatRoom updateChatRoom(Long roomId, ChatRoom chatRoomDetails) {
        Optional<ChatRoom> chatRoomOptional = chatRoomRepository.findById(roomId);
        if (chatRoomOptional.isPresent()) {
            ChatRoom chatRoom = chatRoomOptional.get();
            chatRoom.setRoomName(chatRoomDetails.getRoomName());
            chatRoom.setPublic(chatRoomDetails.isPublic());
            return chatRoomRepository.save(chatRoom);
        } else {
            throw new RuntimeException("ChatRoom not found with id: " + roomId);
        }
    }

    @Override
    public void deleteChatRoom(Long roomId) {
        chatRoomRepository.deleteById(roomId);
    }
}
