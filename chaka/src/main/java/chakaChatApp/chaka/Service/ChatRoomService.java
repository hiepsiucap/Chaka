package chakaChatApp.chaka.Service;

import chakaChatApp.chaka.Entity.ChatRoom;

import java.util.List;
import java.util.Optional;

 public  interface ChatRoomService {
    List<ChatRoom> getAllChatRooms();
    Optional<ChatRoom> getChatRoomById(Long roomId);
    ChatRoom createPrivateChatRoom(ChatRoom chatRoom);
    ChatRoom createGroupChatRoom(ChatRoom chatRoom);
    ChatRoom updateChatRoom(Long roomId, ChatRoom chatRoomDetails);
    void deleteChatRoom(Long roomId);
}
