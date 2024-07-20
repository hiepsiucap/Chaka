package chakaChatApp.chaka.Controller;

import chakaChatApp.chaka.DTO.MessageDTO;
import chakaChatApp.chaka.Entity.ChatRoom;
import chakaChatApp.chaka.Entity.Message;
import chakaChatApp.chaka.Entity.User;
import chakaChatApp.chaka.ExceptionHandler.BadRequest;
import chakaChatApp.chaka.Service.ChatRoomService;
import chakaChatApp.chaka.Service.MessageService;
import chakaChatApp.chaka.Service.RoomMemberService;
import chakaChatApp.chaka.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private final MessageService messageService;
    private  final UserService userService;
    private  final RoomMemberService roomMemberService;
    private  final ChatRoomService chatRoomService;
    @Autowired
    public MessageController(MessageService messageService, UserService userService, RoomMemberService roomMemberService, ChatRoomService chatRoomService) {
        this.messageService = messageService;
        this.userService = userService;
        this.roomMemberService = roomMemberService;
        this.chatRoomService = chatRoomService;
    }

    @GetMapping
    public List<Message> getAllMessages() {
        return messageService.getAllMessages();
    }

    @GetMapping("/{messageId}")
    public ResponseEntity<Message> getMessageById(@PathVariable Long messageId) {
        Optional<Message> message = messageService.getMessageById(messageId);
        return message.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("")
    public ResponseEntity<Message> receivePublicMessage(@RequestBody MessageDTO message)
    {

        User user = userService.getCurrentUser();
        Optional<ChatRoom> chatRoom= chatRoomService.getChatRoomById(message.chatRoomId());

        if(roomMemberService.CheckRoomMember(user.getUserId(), message.chatRoomId()) && chatRoom.isPresent())
        {
            Message message2= new Message();
            message2.setMessageText(message.messageText());
            message2.setChatRoom(chatRoom.get());
            message2.setUser(user);
            Message message1= messageService.createMessage(message2);
            String destination = STR."/topic/chatroom/\{chatRoom.get().getRoomId()}";
            return ResponseEntity.ok(message1);
        }
        else
        {
            throw new BadRequest("Xác minh không thành công");
        }
    }

    @PutMapping("/{messageId}")
    public ResponseEntity<Message> updateMessage(@PathVariable Long messageId, @RequestBody Message messageDetails) {
        try {
            Message updatedMessage = messageService.updateMessage(messageId, messageDetails);
            return ResponseEntity.ok(updatedMessage);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{messageId}")
    public ResponseEntity<Void> deleteMessage(@PathVariable Long messageId) {
        messageService.deleteMessage(messageId);
        return ResponseEntity.noContent().build();
    }
}
