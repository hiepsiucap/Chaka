package chakaChatApp.chaka.Service;

import chakaChatApp.chaka.DTO.ChatRoomDTO;
import chakaChatApp.chaka.DTO.UserDTO;
import chakaChatApp.chaka.Entity.ChatRoom;
import chakaChatApp.chaka.Entity.Message;
import chakaChatApp.chaka.Entity.RoomMember;
import chakaChatApp.chaka.Entity.User;
import chakaChatApp.chaka.ExceptionHandler.BadRequest;
import chakaChatApp.chaka.Respository.ChatRoomRepository;
import chakaChatApp.chaka.Respository.MessageRepository;
import chakaChatApp.chaka.Respository.RoomMemberRepository;
import chakaChatApp.chaka.Respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Autowired
    private RoomMemberRepository roomMemberRepository;

    @Autowired
    private ChatRoomRepository chatRoomRepository;

    @Autowired
    private  final MessageRepository messageRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, MessageRepository messageRepository) {
        this.userRepository = userRepository;
        this.messageRepository = messageRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User createUser(User user) {


        Optional<User> userOptional = userRepository.findByUsername(user.getUsername());
        if (userOptional.isPresent()) {
            throw  new BadRequest("UserName đã tồn tại vui lòng thử lại");
        }
        Optional<User> userOptional1 = userRepository.findByEmail(user.getEmail());
        if (userOptional1.isPresent()) {
            throw  new BadRequest("Email đã tồn tại vui lòng thử lại");
        }
        Optional<User> userOptional2 = userRepository.findByPhoneNumber(user.getPhoneNumber());
        if (userOptional2.isPresent()) {
            throw  new BadRequest("Số điện thoại đã tồn tại đã tồn tại vui lòng thử lại");
        }

           return userRepository.save(user);
    }
    private ChatRoomDTO convertToChatRoomDTO(ChatRoom chatRoom) {
        List<UserDTO> participants = chatRoom.getUsers().stream()
                .map(user -> new UserDTO(user.getUserId(), user.getUsername(), user.getAva()))
                .collect(Collectors.toList());
        Optional<Message> message = messageRepository.findTopByChatRoomOrderBySentAtDesc(chatRoom);
        return message.map(value -> new ChatRoomDTO(chatRoom.getRoomId(), chatRoom.getRoomName(), chatRoom.isGroup(), participants, value)).orElseGet(() -> new ChatRoomDTO(chatRoom.getRoomId(), chatRoom.getRoomName(), chatRoom.isGroup(), participants));
    }
    public List<ChatRoomDTO> getRoomsForUser(Long userId) {
        List<RoomMember> roomMembers = roomMemberRepository.findByUserId(userId);
        List<ChatRoom> chatRooms= roomMembers.stream()
                .map(RoomMember::getChatRoom)
                .toList();
        return chatRooms.stream().map(this::convertToChatRoomDTO).collect(Collectors.toList());

    }
    @Override
    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getPrincipal());
        if (authentication.getPrincipal() != null) {

            Optional<User> currUser = userRepository.findByUsername((String) authentication.getPrincipal());
            if (currUser.isPresent()) {
                return currUser.get();
            }
            ;
        }
             return null;
    }
    @Override
    public User updateUser(Long userId, User userDetails) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setUsername(userDetails.getUsername());
            user.setPassword(userDetails.getPassword());
            user.setEmail(userDetails.getEmail());
            user.setPhoneNumber(userDetails.getPhoneNumber());
            user.setActive(userDetails.isActive());
            user.setVerified(userDetails.isVerified());
            return userRepository.save(user);
        } else {
            throw new RuntimeException("User not found with id: " + userId);
        }
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
