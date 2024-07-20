package chakaChatApp.chaka.Controller;

import chakaChatApp.chaka.DTO.ChatRoomIdDTO;
import chakaChatApp.chaka.Entity.ChatRoom;
import chakaChatApp.chaka.Entity.Message;
import chakaChatApp.chaka.Entity.RoomMember;
import chakaChatApp.chaka.Entity.User;
import chakaChatApp.chaka.ExceptionHandler.BadRequest;
import chakaChatApp.chaka.Service.ChatRoomService;
import chakaChatApp.chaka.Service.MessageService;
import chakaChatApp.chaka.Service.RoomMemberService;
import chakaChatApp.chaka.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/chatrooms")
public class ChatRoomController {
    @Autowired
    private final ChatRoomService chatRoomService;
    @Autowired
    private  final UserService userService;
    @Autowired
    private  final RoomMemberService roomMemberService;
    @Autowired
    private final MessageService messageService;


    public ChatRoomController(ChatRoomService chatRoomService, UserService userService, RoomMemberService roomMemberService, MessageService messageService) {
        this.chatRoomService = chatRoomService;
        this.userService = userService;
        this.roomMemberService = roomMemberService;
        this.messageService = messageService;
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

    @PostMapping("/createGroup")
    public  ResponseEntity<ChatRoom> createGroupChat(@RequestBody ChatRoom chatRoom) {
        User user = userService.getCurrentUser();
        ChatRoom chatRoom1 = chatRoomService.createGroupChatRoom(chatRoom);
        if (chatRoom1 == null) {
            throw new BadRequest("Tạo phòng không thành công");
        }
            RoomMember roomMember = new RoomMember(chatRoom1.getRoomId(), user.getUserId(), "admin", chatRoom1, user);
            roomMemberService.createRoomMember(roomMember);
            return ResponseEntity.ok(chatRoom1);
    }
    @PostMapping("/createPrivate")
    public ResponseEntity<ChatRoom>  createPrivateChat(@RequestBody ChatRoom chatRoom)
    {
        User user = userService.getCurrentUser();
        ChatRoom chatRoom1 = chatRoomService.createPrivateChatRoom(chatRoom);
        if (chatRoom1 == null) {
            throw new BadRequest("Tạo phòng không thành công");
        }
        RoomMember roomMember = new RoomMember(chatRoom1.getRoomId(), user.getUserId(), "admin", chatRoom1, user);
        roomMemberService.createRoomMember(roomMember);
        return ResponseEntity.ok(chatRoom1);
    }
    @GetMapping("/detailChatroomMessage")
    public  ResponseEntity<List<Message>> GetDetailChatroom(@RequestBody ChatRoomIdDTO chatRoomIdDTO)
    {
        User user = userService.getCurrentUser();
        if(!roomMemberService.CheckRoomMember(user.getUserId(),chatRoomIdDTO.getChatRoomId()))
        {
            throw new BadRequest("Nhóm chat không chứa chấp bạn");
        }
        Optional<ChatRoom> tempChatroom= chatRoomService.getChatRoomById(chatRoomIdDTO.getChatRoomId());
        if(tempChatroom.isPresent())
        {
            ChatRoom chatRoom=tempChatroom.get();
            List<Message> messages= messageService.getMessageByChatRoom(chatRoom);
            return  ResponseEntity.ok(messages);
        }
        else
        {
            throw  new BadRequest("Không tìm thấy phòng ");
        }
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
