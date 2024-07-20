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
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import java.util.Optional;

public class ChatController {
    private  final RoomMemberService roomMemberService;
    private  final MessageService messageService;
    private  final UserService userService;
    private final SimpMessagingTemplate messagingTemplate;
    private  final  ChatRoomService chatRoomService;

    public ChatController(RoomMemberService roomMemberService, MessageService messageService, UserService userService, SimpMessagingTemplate messagingTemplate, ChatRoomService chatRoomService) {
        this.roomMemberService = roomMemberService;
        this.messageService = messageService;
        this.userService = userService;
        this.messagingTemplate = messagingTemplate;
        this.chatRoomService = chatRoomService;
    }
    @MessageMapping("/message")
    public ResponseEntity<Message> receivePublicMessage(@Payload MessageDTO message)
    {

        User user = userService.getCurrentUser();
        Optional<ChatRoom> chatRoom= chatRoomService.getChatRoomById(message.chatRoomId());

        if(roomMemberService.CheckRoomMember(user.getUserId(), message.chatRoomId()) && chatRoom.isPresent())
        {
            Message message2= new Message();
            message2.setMessageText(message.messageText());
            message2.setChatRoom(chatRoom.get());
            Message message1= messageService.createMessage(message2);
            String destination = STR."/topic/chatroom/\{chatRoom.get().getRoomId()}";
            messagingTemplate.convertAndSend(destination, message1);
            return ResponseEntity.ok(message1);
        }
        else
        {
            throw new BadRequest("Xác minh không thành công");
        }
    }
}
