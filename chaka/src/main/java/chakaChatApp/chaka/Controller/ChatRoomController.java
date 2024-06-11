package chakaChatApp.chaka.Controller;

import chakaChatApp.chaka.Entity.ChatRoom;
import chakaChatApp.chaka.Service.ChatRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/chatrooms")
public class ChatRoomController {

    private final ChatRoomService chatRoomService;

    @Autowired
    public ChatRoomController(ChatRoomService chatRoomService) {
        this.chatRoomService = chatRoomService;
    }

    @GetMapping
    public List<ChatRoom> getAllChatRooms() {
        return chatRoomService.getAllChatRooms();
    }

    @GetMapping("/{roomId}")
    public ResponseEntity<ChatRoom> getChatRoomById(@PathVariable Long roomId) {
        Optional<ChatRoom> chatRoom = chatRoomService.getChatRoomById(roomId);
        return chatRoom.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ChatRoom createChatRoom(@RequestBody ChatRoom chatRoom) {
        return chatRoomService.createChatRoom(chatRoom);
    }

    @PutMapping("/{roomId}")
    public ResponseEntity<ChatRoom> updateChatRoom(@PathVariable Long roomId, @RequestBody ChatRoom chatRoomDetails) {
        try {
            ChatRoom updatedChatRoom = chatRoomService.updateChatRoom(roomId, chatRoomDetails);
            return ResponseEntity.ok(updatedChatRoom);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{roomId}")
    public ResponseEntity<Void> deleteChatRoom(@PathVariable Long roomId) {
        chatRoomService.deleteChatRoom(roomId);
        return ResponseEntity.noContent().build();
    }
}
